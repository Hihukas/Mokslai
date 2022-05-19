package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;
import lt.codeacademy.Utility;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class RegistrationWindow extends AbstractWindow {
    private final Utility utility;

    public RegistrationWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Users.json");

        List<User> usersList = objectMapper.readValue(file, new TypeReference<>() {
        });

        RegistrationWindow registrationWindow = new RegistrationWindow(utility);

        String userName = registrationWindow.usernameCheck(usersList);
        System.out.println("Sukurkite slaptažodį:");
        String password = utility.getScanner().nextLine();
        if (!passwordCheck(password)) {
            System.out.println("Paskyros sukurti nepavyko.\n");
            window();
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

        usersList.add(user);
        objectMapper.writeValue(file, usersList);

        System.out.printf("\nSveikiname prisijungus, %s!\n", name);
        StudentWindow window = new StudentWindow(user, utility);
        window.window();
    }

    private String usernameCheck(List<User> usersList) {
        while (true) {
            System.out.println("Sukurkite vartotojo vardą:");
            String userName = utility.getScanner().nextLine();

            boolean userNameAlreadyExists = usersList.stream()
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

