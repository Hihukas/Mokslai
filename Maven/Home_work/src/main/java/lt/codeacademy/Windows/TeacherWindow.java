package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;

import java.util.Scanner;

public class TeacherWindow extends AbstractWindow {
    private final User user;

    public TeacherWindow(User user) {
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Egzaminų rezultatai.
                [2] - Sukurti testo egzaminą.
                [3] - Testo egzaminų redagavimas.
                [4] - Atsijungti ir grįžti į pagrindinį meniu.
                """);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                StudentsExamsResultsWindow studentsExamsResultsWindow = new StudentsExamsResultsWindow(user);
                studentsExamsResultsWindow.window();
            }
            case "2" -> {
                ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user);
                examsCreateWindow.window();
            }
            case "3" -> {
                ExamsWindow examsWindow = new ExamsWindow(user, this, true);
                examsWindow.window();
            }
            case "4" -> {
                MainWindow mainWindow = new MainWindow();
                mainWindow.window();
            }
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
                TeacherWindow teacherWindow = new TeacherWindow(user);
                teacherWindow.window();
            }
        }
    }
}

