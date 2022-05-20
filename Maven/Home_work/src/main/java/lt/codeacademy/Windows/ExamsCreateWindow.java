package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.ExamType;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.util.*;


public class ExamsCreateWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public ExamsCreateWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    public void window() throws Exception {
        List<Exam> exams = utility.getExamsList();

        List<Question> questions = new ArrayList<>();

        System.out.println("Įveskite testo egzamino temą:");
        String examTheme = utility.getScanner().nextLine();

        questionsCreate(questions);

        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, examTheme, questions));

        utility.setExamsList(exams);

        System.out.println("\nInformacija išsaugota.");

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction(user);
    }

    public void questionsCreate(List<Question> questions) {
        System.out.println("Įveskite norimą klausimų kiekį:");
        int examQuestionsQuantity = (utility.getScanner().nextInt() - 1);
        utility.getScanner().nextLine();

        for (int i = 0; i <= examQuestionsQuantity; i++) {
            System.out.println("Sukurkite klausimą:");
            String question = (utility.getScanner().nextLine() + "\nAtsakymų variantai:");

            System.out.println("Įveskite norimą atsakymų kiekį:");
            int examQuestionsAnswersQuantity = (utility.getScanner().nextInt() - 1);
            utility.getScanner().nextLine();
            List<String> answers = new ArrayList<>();
            for (int a = 0; a <= examQuestionsAnswersQuantity; a++) {
                System.out.println("Įrašykite atsakymą:");
                String answer = utility.getScanner().nextLine();
                answers.add(answer);
            }
            System.out.println("Nurodykite teisingą atsakymą:");
            int correctAnswer = utility.getScanner().nextInt();
            utility.getScanner().nextLine();

            Question questionObject = new Question();
            questionObject.setQuestion(question);
            questionObject.setAnswers(answers);
            questionObject.setCorrectAnswer(correctAnswer);

            questions.add(questionObject);
        }
    }
}

