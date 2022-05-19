package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;
import lt.codeacademy.Utility;

import java.util.UUID;

public class RegistrationWindow extends AbstractWindow {
    private final Utility utility;

    public RegistrationWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        String userName = usernameCheck();
        System.out.println("Sukurkite slaptažodį:");
        String password = utility.getScanner().nextLine();
        if (!passwordCheck(password)) {
            System.out.println("Paskyros sukurti nepavyko.\n");
            RegistrationWindow registrationWindow = new RegistrationWindow(utility);
            registrationWindow.window();
        }
        System.out.println("Įveskite savo vardą:");
        String name = utility.getScanner().nextLine();
        System.out.println("Įveskite savo pavardę:");
        String surname = utility.getScanner().nextLine();

        User user = new User()
                .setId(UUID.randomUUID())
                .setUserType(UserType.STUDENT)
                .setUsername(userName)
                .setPassword(password)
                .setName(name)
                .setSurname(surname);

        utility.getUsersList().add(user);

        System.out.printf("\nSveikiname prisijungus, %s!\n", name);
        StudentWindow window = new StudentWindow(user, utility);
        window.window();
    }

    private String usernameCheck() {
        while (true) {
            System.out.println("Sukurkite vartotojo vardą:");
            String userName = utility.getScanner().nextLine();

            boolean userNameAlreadyExists = utility.getUsersList().stream()
                    .anyMatch(u -> u.getUsername().equals(userName));

            if (userNameAlreadyExists) {
                System.out.println("Toks vartotojo vardas jau egzistuoja.\n");
                continue;
            }
            return userName;
        }
    }

    private boolean passwordCheck(String password) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Pakartokite slaptažodžio įvedimą:");
            String repeatPassword = utility.getScanner().nextLine();
            if (!repeatPassword.equals(password)) {
                System.out.println("Slaptažodžiai nesutampa.\n");
                continue;
            }
            return true;
        }
        return false;
    }
}

