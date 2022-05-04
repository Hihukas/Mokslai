import java.util.Map;
import java.util.Scanner;

public class Login {
    public void login(Scanner scanner, Map<String, String> users) {
        System.out.println("Įveskite prisijungimo vardą:");
        String userName = scanner.nextLine();
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();

        String doesUserPasswordExists = users.get(userName);
        if (doesUserPasswordExists == null) {
            System.out.println("Tokio vartotojo nėra.");
            return;
        }

        if (doesUserPasswordExists.equals(password)) {
            System.out.println("Neteisingas slaptažodis.");
            return;
        }

        System.out.printf("Sveikiname %s prisijungus \n", userName);
    }
}
