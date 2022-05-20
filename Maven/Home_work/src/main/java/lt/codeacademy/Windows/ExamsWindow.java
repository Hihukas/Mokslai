package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class ExamsWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;
    private final AbstractWindow previousWindow;
    private final boolean editMode;

    public ExamsWindow(User user, AbstractWindow previousWindow, boolean editMode, Utility utility) {
        this.user = user;
        this.previousWindow = previousWindow;
        this.editMode = editMode;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        List<Exam> examsToTake = getExams(utility.getExamsList());

        if (examsToTake.size() == 0) {
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
            int index = (utility.getScanner().nextInt() - 1);
            Exam exam = examsToTake.get(index);
            if (editMode) {
                ExamsEditingWindow examsEditingWindow = new ExamsEditingWindow(user, exam, index, utility);
                examsEditingWindow.window();
            } else {
                QuestionsWindow questionsWindow = new QuestionsWindow(exam, user, utility);
                questionsWindow.window();
            }
        } catch (InputMismatchException e) {
            System.out.println("Galimi tik skaičiai.\n");
            ExamsWindow examsWindow = new ExamsWindow(user, previousWindow, editMode, utility);
            examsWindow.window();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tokio egzamino nėra! Rinkites dar kartą.\n");
            ExamsWindow examsWindow = new ExamsWindow(user, previousWindow, editMode, utility);
            examsWindow.window();
        }
    }

    private List<Exam> getExams(List<Exam> exams) {
        return editMode ? exams : getUsersExamsToTake(exams);
    }

    private List<Exam> getUsersExamsToTake(List<Exam> exams) {
        OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(user, utility);
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

