package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;

import java.util.Scanner;


public class ExamsEditingWindow extends AbstractWindow {
    @Override
    public void window() throws Exception {
    }

    private void chooseAction(Scanner scanner, User user) throws Exception {
        System.out.println("""
                Testo egzaminas išsaugotas.
                                
                [1] Grįžti į dėstytojo meniu.
                [2] Kurti naują testo egzaminą.
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
            default -> System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
        }
    }
}

