package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.ExamType;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.MainModel;

import java.util.*;

public class ExamsCreateWindow extends AbstractWindow {
    private final MainModel mainModel;

    public ExamsCreateWindow(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void window() {
        List<Exam> exams = mainModel.getExamsList();

        List<Question> questions = new ArrayList<>();

        System.out.println("Įveskite testo egzamino temą:");
        String examTheme = mainModel.getScanner().nextLine();

        questionsCreate(questions);

        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, examTheme, questions));

        mainModel.setExamsList(exams);

        System.out.println("\nInformacija išsaugota.");

        ReturnAction returnAction = new ReturnAction(mainModel);
        returnAction.returnAction();
    }

    public void questionsCreate(List<Question> questions) {
        System.out.println("Įveskite norimą klausimų kiekį:");
        int examQuestionsQuantity = (mainModel.getScanner().nextInt() - 1);
        mainModel.getScanner().nextLine();

        for (int i = 0; i <= examQuestionsQuantity; i++) {
            System.out.println("Sukurkite klausimą:");
            String question = (mainModel.getScanner().nextLine() + "\nAtsakymų variantai:");

            System.out.println("Įveskite norimą atsakymų kiekį:");
            int examQuestionsAnswersQuantity = (mainModel.getScanner().nextInt() - 1);
            mainModel.getScanner().nextLine();
            List<String> answers = new ArrayList<>();
            for (int a = 0; a <= examQuestionsAnswersQuantity; a++) {
                System.out.println("Įrašykite atsakymą:");
                String answer = mainModel.getScanner().nextLine();
                answers.add(answer);
            }
            System.out.println("Nurodykite teisingą atsakymą:");
            int correctAnswer = mainModel.getScanner().nextInt();
            mainModel.getScanner().nextLine();

            Question questionObject = new Question();
            questionObject.setQuestion(question);
            questionObject.setAnswers(answers);
            questionObject.setCorrectAnswer(correctAnswer);

            questions.add(questionObject);
        }
    }
}

