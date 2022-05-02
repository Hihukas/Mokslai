import org.apache.commons.codec.digest.DigestUtils;

import javax.security.auth.login.LoginContext;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {

    String userName;
    String userPassword;
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, String> users = new TreeMap<>();

    public void chooseAction() {
        String action;
        do {
            System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Prisijungimas.
                    [2] - Registracija.
                    [3] - Išeiti.
                    """);
            action = scanner.nextLine();
            switch (action) {
                case "1" -> login(scanner);
                case "2" -> registration(scanner);
                case "3" -> System.out.println("Programa baigia darbą.");
                default -> System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
            }
        } while (!action.equals("1") && !action.equals("2") && !action.equals("3"));
    }

    public void registration(Scanner scanner) {
        String userName = userName(scanner);
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();
        if (!userPassword(scanner, password)) {
            System.out.println("Paskyros sukurti nepavyko.");
            return;
        }
        users.put(userName, DigestUtils.sha512Hex(password));
        System.out.println("Sveikiname prisiregistravus.");
    }

    public void login(Scanner scanner){
        System.out.println("Įveskite prisijungimo vardą:");
        String userName = scanner.nextLine();
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();

        String doesUserPasswordExists = users.get(userName);
        if(doesUserPasswordExists == null){
            System.out.println("Tokio vartotojo nėra.");
            return;
        }

        if(doesUserPasswordExists.equals(DigestUtils.sha512Hex(password))){
            System.out.println("Neteisingas slaptažodis.");
            return;
        }

        System.out.printf("Sveikiname %s prisijungus \n", userName);
        }

    private String userName(Scanner scanner) {
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
