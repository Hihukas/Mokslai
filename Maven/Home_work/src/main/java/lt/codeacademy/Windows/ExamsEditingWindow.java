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

        System.out.println("""
                [1] Ištrinti klausimus.
                [2] Papildyti egzaminą klausimais.
                [3] Grįžti į dėstytojo meniu.
                """);

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> changeQuestions(exam);
            case "2" -> System.out.println("bla, bla");
            case "3" -> {
                TeacherWindow teacherWindow = new TeacherWindow(user);
                teacherWindow.window();
            }
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
                ExamsEditingWindow examsEditingWindow = new ExamsEditingWindow(user, exam);
                examsEditingWindow.window();
            }
        }

        chooseAction(scanner, user);
    }

    private void changeQuestions(Exam exam, Scanner scanner) {
        System.out.println("Pasirinkite norimą ištrinti klausimą:\n");

        IntStream.range(0, exam.getQuestions().size())
                .mapToObj(i -> {
                    Question q = exam.getQuestions().get(i);
                    return "[" + (i + 1) + "] " + q.getQuestion() +
                            q.getAnswers() + "\n";
                }).forEach(System.out::println);

        List<Question> questions = exam.get(scanner.nextInt() - 1);
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

