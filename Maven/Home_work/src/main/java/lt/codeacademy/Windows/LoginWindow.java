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

        utility.setUser(login(userName, password));

        if (utility.getUser() == null) {
            System.out.println("Tokio vartotojo vardo arba slaptažodžio nėra. Bandykite iš naujo.\n");
            LoginWindow loginWindow = new LoginWindow(utility);
            loginWindow.window();
        } else {
            switch (utility.getUser().getUserType()) {
                case STUDENT -> {
                    System.out.printf("\nSveikiname prisijungus, %s!\n", utility.getUser().getName());
                    StudentWindow studentWindow = new StudentWindow(utility);
                    studentWindow.window();
                }
                case LECTOR -> {
                    System.out.printf("\nSveikiname prisijungus, %s!\n", utility.getUser().getName());
                    LectorWindow lectorWindow = new LectorWindow(utility);
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



