package lt.codeacademy.Windows;

import java.util.Scanner;

public class MainWindow extends AbstractWindow {
    @Override
    public void window() throws Exception {
        String input;
        do {
            System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Prisijungimas.
                    [2] - Naujų studentų registracija.
                    [3] - Išeiti.
                    """);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    LoginWindow loginWindow = new LoginWindow();
                    loginWindow.window();
                }
                case "2" -> {
                    System.out.println("2");
                }
                case "3" -> System.out.println("Programa baigia darbą.");
                default -> {
                    System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                }
            }
        } while (!(input.equals("1") || input.equals("2") || input.equals("3")));
    }
}


