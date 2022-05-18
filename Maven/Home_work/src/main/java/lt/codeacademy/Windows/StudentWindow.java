package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;

import java.util.Scanner;

public class StudentWindow extends AbstractWindow {
    private final User user;

    public StudentWindow(User user) {
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Laikyti egzaminą.
                [2] - Egzaminų rezultatai.
                [3] - Atsijungti ir grįžti į pagrindinį meniu.
                """);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                ExamsWindow examsWindow = new ExamsWindow(user, this, false);
                examsWindow.window();
            }
            case "2" -> {
                OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(user);
                oneStudentExamsResultsWindow.window();
            }
            case "3" -> {
                MainWindow mainWindow = new MainWindow();
                mainWindow.window();
            }
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
                StudentWindow studentWindow = new StudentWindow(user);
                studentWindow.window();
            }
        }
    }
}
