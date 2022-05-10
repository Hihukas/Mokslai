package lt.codeacademy.Windows;

import lt.codeacademy.Users.UserType;

import java.util.Scanner;

public class TeacherWindow extends AbstractWindow {

    private Enum<UserType> userType;

    public TeacherWindow(Enum<UserType> userType) {
        this.userType = userType;
    }

    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Egzaminų rezultatai.
                [2] - Sukurti egzaminą.
                [3] - Egzaminų redagavimas.
                [4] - Išeiti.
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("open tests");
            case "2" -> System.out.println("open tests");
            case "3" -> {
                ExamsWindow frame = new ExamsWindow(userType);
                frame.window();
            }
            case "4" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                TeacherWindow frame = new TeacherWindow(userType);
                frame.window();
            }
        }
    }
}

