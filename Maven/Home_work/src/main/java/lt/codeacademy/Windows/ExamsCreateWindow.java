package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Exams.ExamType;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;

import java.io.File;
import java.util.*;


public class ExamsCreateWindow extends AbstractWindow {
    private User user;

    public ExamsCreateWindow(User user) {
        this.user = user;
    }

    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });

        List<Question> questions = new ArrayList<>();

        System.out.println("Įveskite testo egzamino temą:");
        String examTheme = scanner.nextLine();

        questionsCreate(scanner, questions);

        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, examTheme, questions));

        objectMapper.writeValue(file, exams);

        System.out.println("\nInformacija išsaugota.");

        returnAction(scanner, user);
    }

    public void questionsCreate(Scanner scanner, List<Question> questions) {
        System.out.println("Įveskite norimą klausimų kiekį:");
        int examQuestionsQuantity = (scanner.nextInt() - 1);
        scanner.nextLine();

        for (int i = 0; i <= examQuestionsQuantity; i++) {
            System.out.println("Sukurkite klausimą:");
            String question = (scanner.nextLine() + "\nAtsakymų variantai:");

            System.out.println("Įveskite norimą atsakymų kiekį:");
            int examQuestionsAnswersQuantity = (scanner.nextInt() - 1);
            scanner.nextLine();
            List<String> answers = new ArrayList<>();
            for (int a = 0; a <= examQuestionsAnswersQuantity; a++) {
                System.out.println("Įrašykite atsakymą:");
                String answer = scanner.nextLine();
                answers.add(answer);
            }
            System.out.println("Nurodykite teisingą atsakymą:");
            int correctAnswer = scanner.nextInt();
            scanner.nextLine();

            Question questionObject = new Question();
            questionObject.setQuestion(question);
            questionObject.setAnswers(answers);
            questionObject.setCorrectAnswer(correctAnswer);

            questions.add(questionObject);
        }
    }

    public void returnAction(Scanner scanner, User user) throws Exception {
        String input;
        do {
            System.out.println("""    
                                                   
                    [1] Grįžti į dėstytojo meniu.
                    """);
            input = scanner.nextLine();
            if ("1".equals(input)) {
                TeacherWindow teacherWindow = new TeacherWindow(user);
                teacherWindow.window();
            } else {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
            }
        } while (!input.equals("1"));
    }
}

