package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Utility;

import java.io.File;
import java.util.List;

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

        switch (user.getUserType()) {
            case STUDENT -> {
                System.out.printf("\nSveikiname prisijungus, %s!\n", user.getName());
                StudentWindow studentWindow = new StudentWindow(user, utility);
                studentWindow.window();
            }
            case LECTOR -> {
                System.out.printf("\nSveikiname prisijungus, %s!\n", user.getName());
                TeacherWindow teacherWindow = new TeacherWindow(user, utility);
                teacherWindow.window();
            }
            default -> {
                System.out.println("Neteisingas vartotojo vardas arba slaptažodis. Bandykite dar kartą.\n");
                LoginWindow loginWindow = new LoginWindow(utility);
                loginWindow.window();
            }
        }
    }

    private User login(String userName, String password) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Users.json");
        List<User> usersList = objectMapper.readValue(file, new TypeReference<>() {
        });

        return usersList.stream()
                .filter(u -> u.getUsername().equals(userName) && u.getPassword().equals(password))
                .findAny()
                .orElse(null);
    }
}



