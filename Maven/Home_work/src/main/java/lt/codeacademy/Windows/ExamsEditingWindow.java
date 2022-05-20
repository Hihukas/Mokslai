package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.util.ArrayList;
import java.util.List;


public class ExamsEditingWindow extends AbstractWindow {
    private final User user;
    private final Exam exam;

    private final Utility utility;
    private final int index;

    public ExamsEditingWindow(User user, Exam exam, int index, Utility utility) {
        this.user = user;
        this.exam = exam;
        this.index = index;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        List<Exam> exams = utility.getExamsList();

        List<Question> oldQuestions = exam.getQuestions().stream().toList();

        List<Question> questions = new ArrayList<>(oldQuestions);

        ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user, utility);

        examsCreateWindow.questionsCreate(questions);

        exams.set(index, new Exam(exam.getId(), exam.getExamType(), exam.getName(), questions));

        utility.setExamsList(exams);

        System.out.println("\nInformacija išsaugota.");

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction(user);
    }
}

