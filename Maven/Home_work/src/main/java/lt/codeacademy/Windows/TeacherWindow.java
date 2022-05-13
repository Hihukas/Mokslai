package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.util.Scanner;

public class TeacherWindow extends AbstractWindow {
    private User user;
    private Enum<UserType> userType;

    public TeacherWindow(Enum<UserType> userType, User user) {
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        String input;
        do {
            System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Egzaminų rezultatai.
                    [2] - Sukurti egzaminą.
                    [3] - Egzaminų redagavimas.
                    [4] - Atsijungti ir grįžti į pagrindinį meniu.
                    """);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    StudentsExamsResultsWindow studentsExamsResultsWindow = new StudentsExamsResultsWindow(userType, user);
                    studentsExamsResultsWindow.window();
                }
                case "2" -> System.out.println("open tests");
                case "3" -> {
                    ExamsWindow examsWindow = new ExamsWindow(userType, user);
                    examsWindow.window();
                }
                case "4" -> {
                    MainWindow mainWindow = new MainWindow();
                    mainWindow.window();
                }
                default -> System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
            }
        } while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")));
    }
}

