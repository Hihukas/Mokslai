package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


public class ExamsEditingWindow extends AbstractWindow {
    private final User user;
    private final Exam exam;

    public ExamsEditingWindow(User user, Exam exam) {
        this.user = user;
        this.exam = exam;
    }

    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = exam.getQuestions().stream().toList();

        ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user);
        examsCreateWindow.questionCreate(scanner, questions);

        chooseAction(scanner, user);
    }

    private void addQuestions(Exam exam, Scanner scanner) {
        System.out.println("Sukurkite klausimą:\n");

        IntStream.range(0, exam.getQuestions().size())
                .mapToObj(i -> {
                    Question q = exam.getQuestions().get(i);
                    return "[" + (i + 1) + "] " + q.getQuestion() +
                            q.getAnswers() + "\n";
                }).forEach(System.out::println);

        List<Question> questions = exam.getQuestions().stream().toList();
        questions.remove(scanner.nextInt() - 1);
    }

    private void chooseAction(Scanner scanner, User user) throws Exception {
        System.out.println("""
                Informacija išsaugota.
                                
                [1] Grįžti į dėstytojo meniu.
                """);

        String input = scanner.nextLine();
        if ("1".equals(input)) {
            TeacherWindow teacherWindow = new TeacherWindow(user);
            teacherWindow.window();
        } else {
            System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
            ExamsEditingWindow examsEditingWindow = new ExamsEditingWindow(user, exam);
            examsEditingWindow.chooseAction(scanner, user);
        }
    }
}

