package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.util.Scanner;

public class StudentWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public StudentWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
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
                MainWindow mainWindow = new MainWindow(utility);
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
