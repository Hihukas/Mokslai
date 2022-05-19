package lt.codeacademy.Windows;

import lt.codeacademy.Utility;

import java.util.Scanner;

public class MainWindow extends AbstractWindow {
    private final Utility utility;

    public MainWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Prisijungimas.
                [2] - Naujų studentų registracija.
                [3] - Išeiti.
                """);
        String input = utility.getScanner().nextLine();
        switch (input) {
            case "1" -> {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.window();
            }
            case "2" -> {
                RegistrationWindow registrationWindow = new RegistrationWindow();
                registrationWindow.window();
            }
            case "3" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
                MainWindow mainWindow = new MainWindow(utility);
                mainWindow.window();
            }
        }
    }
}



