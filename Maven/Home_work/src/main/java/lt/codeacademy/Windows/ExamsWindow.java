package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.UserType;
import lt.codeacademy.Utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class ExamsWindow extends AbstractWindow {
    private final Utility utility;

    public ExamsWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() {
        List<Exam> examsToTake = getExams();

        if (examsToTake.size() == 0) {
            System.out.println("Egzaminų sąrašas tuščias.");
            ReturnAction returnAction = new ReturnAction(utility);
            returnAction.returnAction();
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

        examChoose(examsToTake);
    }

    private void examChoose(List<Exam> examsToTake) {
        System.out.println("\nPasirinkite egzaminą:");

        try {
            utility.setScanner(new Scanner(System.in));
            int index = (utility.getScanner().nextInt() - 1);
            utility.getScanner().nextLine();
            utility.setExam(examsToTake.get(index));
            if (utility.getUser().getUserType() == UserType.LECTOR) {
                ExamsEditingWindow examsEditingWindow = new ExamsEditingWindow(index, utility);
                examsEditingWindow.window();
            } else {
                QuestionsWindow questionsWindow = new QuestionsWindow(utility);
                questionsWindow.window();
            }
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Tokio egzamino nėra! Rinkites dar kartą.");
            ExamsWindow examsWindow = new ExamsWindow(utility);
            examsWindow.examChoose(examsToTake);
        }
    }

    private List<Exam> getExams() {
        return (utility.getUser().getUserType() == UserType.LECTOR) ? utility.getExamsList() : getUsersExamsToTake();
    }

    private List<Exam> getUsersExamsToTake() {
        OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(utility);
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

        return utility.getExamsList().stream()
                .filter(e -> restrictedExams.stream().noneMatch(re -> re.getId().equals(e.getId())))
                .toList();
    }
}

