package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.util.Scanner;

public class StudentWindow extends AbstractWindow {
    private User user;
    private Enum<UserType> userType;

    public StudentWindow(Enum<UserType> userType, User user) {
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        String input;
        do {
            System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Laikyti egzaminą.
                    [2] - Egzaminų rezultatai.
                    [3] - Atsijungti ir grįžti į pagrindinį meniu.
                    """);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    ExamsWindow examsWindow = new ExamsWindow(userType, user);
                    examsWindow.window();
                }
                case "2" -> {
                    OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(userType, user);
                    oneStudentExamsResultsWindow.window();
                }
                case "3" -> {
                    MainWindow mainWindow = new MainWindow();
                    mainWindow.window();
                }
                default -> System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
            }
        } while (!(input.equals("1") || input.equals("2") || input.equals("3")));
    }
}
