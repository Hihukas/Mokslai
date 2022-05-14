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
    private User user;
    private Enum<UserType> userType;

    public ExamsWindow(Enum<UserType> userType, User user) {
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Exams.json");

        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });

        List<Exam> examsToTake = getUsersExamsToTake(user, user.getUserType(), exams);

        if(examsToTake.size()==0){
            System.out.println("Galimų laikyti egzaminų sąrašas tuščias.");
            Thread.sleep(3000);
            StudentWindow studentWindow = new StudentWindow(userType, user);
            studentWindow.window();
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
            if (userType.equals(UserType.STUDENT)) {
                QuestionsWindow questionsWindow = new QuestionsWindow(exam, userType, user);
                questionsWindow.window();
            } else {
                System.out.println("Dėstytojo langas");
            }
        } catch (InputMismatchException e) {
            System.out.println("Galimi tik skaičiai.\n");
            window();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tokio egzamino nėra! Rinkites dar kartą.\n");
            window();
        }
    }

    private List<Exam> getUsersExamsToTake(User user, UserType userType, List<Exam> exams) throws Exception {
        OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(userType, user);
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

