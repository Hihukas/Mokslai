package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;

import java.util.List;
import java.util.Scanner;


public class ExamsEditingWindow extends AbstractWindow {
    private final User user;
    private final List<Exam> exams;

    public ExamsEditingWindow(User user, List<Exam> exams) {
        this.user = user;
        this.exams = exams;
    }

    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                [1] Redaguoti klausimus.
                [2] Papildyti egzaminą klausimais.
                [3] Grįžti į dėstytojo meniu.
                """);

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> ;
            case "2" -> ;
            case "3" -> {
                TeacherWindow teacherWindow = new TeacherWindow(user);
                teacherWindow.window();
            };
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
                ExamsEditingWindow examsEditingWindow = new ExamsEditingWindow(user, exams);
                examsEditingWindow.window();
            }
        }

        chooseAction(scanner, user);
    }

    private void chooseAction(Scanner scanner, User user) throws Exception {
        System.out.println("""
                Testo egzaminas išsaugotas.
                                
                [1] Grįžti į dėstytojo meniu.
                [2] Redaguoti kitą testo egzaminą.
                """);

        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                TeacherWindow teacherWindow = new TeacherWindow(user);
                teacherWindow.window();
            }
            case "2" -> {
                ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user);
                examsCreateWindow.window();
            }
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
                ExamsEditingWindow examsEditingWindow = new ExamsEditingWindow(user);
                examsEditingWindow.chooseAction(scanner, user);
            }
        }
    }
}

