package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Utility;

import java.util.ArrayList;
import java.util.List;

public class ExamsEditingWindow extends AbstractWindow {
    private final Utility utility;
    private final int index;

    public ExamsEditingWindow(int index, Utility utility) {
        this.index = index;
        this.utility = utility;
    }

    @Override
    public void window() {
        List<Exam> exams = utility.getExamsList();

        List<Question> oldQuestions = utility.getExam().getQuestions().stream().toList();

        List<Question> questions = new ArrayList<>(oldQuestions);

        ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(utility);

        examsCreateWindow.questionsCreate(questions);

        exams.set(index, new Exam(utility.getExam().getId(), utility.getExam().getExamType(), utility.getExam().getName(), questions));

        utility.setExamsList(exams);

        System.out.println("\nInformacija išsaugota.");

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction();
    }
}

