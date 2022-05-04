import java.util.Map;
import java.util.Scanner;

public class Registration {
    public void registration(Scanner scanner, Map<String, String> users) {
        String userName = userName(scanner, users);
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();
        if (!userPassword(scanner, password)) {
            System.out.println("Paskyros sukurti nepavyko.");
            return;
        }
        users.put(userName, password);
        System.out.println("Sveikiname prisiregistravus.");
    }

    private String userName(Scanner scanner, Map<String, String> users) {
        while (true) {
            System.out.println("Įveskite prisijungimo vardą:");
            String userName = scanner.nextLine();
            String doesUserNameExists = users.get(userName);
            if (doesUserNameExists != null) {
                System.out.println("Toks vartotojo prisijungimo vardas jau egzistuoja.");
                continue;
            }
            return userName;
        }
    }

    private boolean userPassword(Scanner scanner, String password) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Pakartokite slaptažodžio įvedimą:");
            String repeatPassword = scanner.nextLine();
            if (!repeatPassword.equals(password)) {
                System.out.println("Slaptažodžiai nesutampa.");
                continue;
            }
            return true;
        }
        return false;
    }
}
