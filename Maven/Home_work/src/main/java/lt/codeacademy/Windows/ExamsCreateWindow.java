package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Exams.ExamType;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.io.File;
import java.util.*;


public class ExamsCreateWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public ExamsCreateWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    public void window() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });

        List<Question> questions = new ArrayList<>();

        System.out.println("Įveskite testo egzamino temą:");
        String examTheme = utility.getScanner().nextLine();

        questionsCreate(questions);

        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, examTheme, questions));

        objectMapper.writeValue(file, exams);

        System.out.println("\nInformacija išsaugota.");

        returnAction(user);
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

    public void returnAction(User user) throws Exception {
        String input;
        do {
            System.out.println("""    
                                                   
                    [1] Grįžti į dėstytojo meniu.
                    """);
            input = utility.getScanner().nextLine();
            if ("1".equals(input)) {
                TeacherWindow teacherWindow = new TeacherWindow(user, utility);
                teacherWindow.window();
            } else {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
            }
        } while (!input.equals("1"));
    }
}

