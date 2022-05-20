package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.util.*;
import java.util.stream.IntStream;

public class OneStudentExamsResultsWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public OneStudentExamsResultsWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        List<StudentsAnswers> oneStudentsAnswersList = fillOneStudentsAnswersList();

        System.out.println("Egzaminų sąrašas:");

        IntStream.range(0, oneStudentsAnswersList.size())
                .mapToObj(i -> {
                    StudentsAnswers e = oneStudentsAnswersList.get(i);
                    return (i + 1) + " Egzamino ID: " + e.getExam().getId() +
                            ", Egzamino pavadinimas: " + e.getExam().getName() +
                            ", Egzamino tipas: " + e.getExam().getExamType() +
                            ", Pažymys: " + e.getGrade() +
                            ", Egzamino laikymo data: " + e.getTime();
                })
                .forEach(System.out::println);

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction(user);
    }

    public List<StudentsAnswers> fillOneStudentsAnswersList() {
        List<StudentsAnswers> filledOneStudentsAnswersList = new ArrayList<>();

        for (StudentsAnswers id : utility.getStudentsAnswersList()) {
            if (id.getUser().getId().equals(user.getId())) {
                filledOneStudentsAnswersList.add(id);
            }
        }
        return filledOneStudentsAnswersList;
    }
}
