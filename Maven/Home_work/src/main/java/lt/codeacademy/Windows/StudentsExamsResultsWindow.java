package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.time.LocalDateTime;
import java.util.Comparator;

public class StudentsExamsResultsWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public StudentsExamsResultsWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        utility.getStudentsAnswersList().stream()
                .sorted(Comparator.comparing((StudentsAnswers sa) -> sa.getUser().getName())
                        .thenComparing(sa -> sa.getUser().getSurname())
                        .thenComparing(sa -> LocalDateTime.parse(sa.getTime())))
                .map(e -> "\nStudento vardas: " + e.getUser().getName() +
                        "\nStudento pavardė: " + e.getUser().getSurname() +
                        "\nEgzamino ID: " + e.getExam().getId() +
                        ", Egzamino pavadinimas: " + e.getExam().getName() +
                        ", Egzamino tipas: " + e.getExam().getExamType() +
                        "\nPažymys: " + e.getGrade() +
                        "\nEgzamino laikymo data: " + e.getTime())
                .forEachOrdered(System.out::println);

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction(user);
    }
}
