package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class ExamsWindow extends AbstractWindow {
    private final User user;

    private final AbstractWindow previousWindow;

    private final boolean editMode;

    public ExamsWindow(User user, AbstractWindow previousWindow, boolean editMode) {
        this.user = user;
        this.previousWindow = previousWindow;
        this.editMode = editMode;
    }

    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Exam> examsToTake = getExams();

        if(examsToTake.size()==0){
            System.out.println("Egzaminų sąrašas tuščias.");
            Thread.sleep(3000);
            previousWindow.window();
        }

        System.out.println("Egzaminų sąrašas:");

        IntStream.range(0, examsToTake.size())
                .mapToObj(i -> {
                    Exam e = examsToTake.get(i);
                    try {
                        return "[" + (i + 1) + "] Egzamino ID: " + e.getId() +
                                ", Egzamino pavadinimas: " + e.getName() +
                                ", Egzamino tipas: " + e.getExamType();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .forEach(System.out::println);

        System.out.println("\nPasirinkite egzaminą:");

        try {
            Exam exam = examsToTake.get(scanner.nextInt() - 1);
            if (editMode) {
                System.out.println("Editinomo langas");
            } else {
                QuestionsWindow questionsWindow = new QuestionsWindow(exam, user);
                questionsWindow.window();
            }
        } catch (InputMismatchException e) {
            System.out.println("Galimi tik skaičiai.\n");
            window();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tokio egzamino nėra! Rinkites dar kartą.\n");
            window();
        }
    }

    private List<Exam> getExams() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });
        return editMode ?  exams : getUsersExamsToTake(exams);
    }

    private List<Exam> getUsersExamsToTake(List<Exam> exams) throws Exception {
        OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(user);
        List<StudentsAnswers> oneStudentsAnswerList = oneStudentExamsResultsWindow.fillOneStudentsAnswersList();

        List<Exam> restrictedExams = oneStudentsAnswerList.stream()
                .filter(a -> {
                    LocalDateTime time = LocalDateTime.parse(a.getTime());
                    LocalDateTime currentTime = LocalDateTime.now();
                    long examPassedHours = Duration.between(time, currentTime).toHours();
                    return examPassedHours < 48;
                })
                .map(StudentsAnswers::getExam)
                .toList();

        return exams.stream()
                .filter(e -> restrictedExams.stream().noneMatch(re -> re.getId().equals(e.getId())))
                .toList();
    }
}

