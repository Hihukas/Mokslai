package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

public class LoginWindow extends AbstractWindow {
    private final Utility utility;

    public LoginWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        System.out.println("Įveskite vartotojo vardą: ");
        String userName = utility.getScanner().nextLine();
        System.out.println("Įveskite slaptažodį:");
        String password = utility.getScanner().nextLine();

        User user = login(userName, password);
        if (user == null) {
            System.out.println("Tokio vartotojo vardo arba slaptažodžio nėra. Bandykite iš naujo.\n");
            LoginWindow loginWindow = new LoginWindow(utility);
            loginWindow.window();
        }

        if (user != null) {
            switch (user.getUserType()) {
                case STUDENT -> {
                    System.out.printf("\nSveikiname prisijungus, %s!\n", user.getName());
                    StudentWindow studentWindow = new StudentWindow(user, utility);
                    studentWindow.window();
                }
                case LECTOR -> {
                    System.out.printf("\nSveikiname prisijungus, %s!\n", user.getName());
                    LectorWindow lectorWindow = new LectorWindow(user, utility);
                    lectorWindow.window();
                }
            }
        }
    }

    private User login(String userName, String password) {
        return utility.getUsersList().stream()
                .filter(u -> u.getUsername().equals(userName) && u.getPassword().equals(password))
                .findAny()
                .orElse(null);
    }
}



