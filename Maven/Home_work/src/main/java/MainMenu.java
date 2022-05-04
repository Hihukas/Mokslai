import java.util.Map;
import java.util.Scanner;

public class MainMenu implements Menu {
    @Override
    public void menu(Scanner scanner, Map<String, String> users) {
        String action;
        Login login = new Login();
        Registration registration = new Registration();
        do {
            System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Prisijungimas.
                    [2] - Naujų studentų registracija.
                    [3] - Išeiti.
                    """);
            action = scanner.nextLine();
            switch (action) {
                case "1" -> login.login(scanner, users);
                case "2" -> registration.registration(scanner, users);
                case "3" -> System.out.println("Programa baigia darbą.");
                default -> System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
            }
        } while (!action.equals("1") && !action.equals("2") && !action.equals("3"));
    }
}


