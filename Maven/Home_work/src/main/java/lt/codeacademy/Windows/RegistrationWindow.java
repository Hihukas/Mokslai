package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RegistrationWindow extends AbstractWindow {
    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Users.json");

        List<User> usersList = objectMapper.readValue(file, new TypeReference<>() {
        });

        RegistrationWindow registrationWindow = new RegistrationWindow();

        String userName = registrationWindow.usernameCheck(scanner, usersList);
        System.out.println("Sukurkite slaptažodį:");
        String password = scanner.nextLine();
        if (!passwordCheck(scanner, password)) {
            System.out.println("Paskyros sukurti nepavyko.\n");
            window();
        }
        System.out.println("Įveskite savo vardą:");
        String name = scanner.nextLine();
        System.out.println("Įveskite savo pavardę:");
        String surname = scanner.nextLine();

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
        StudentWindow window = new StudentWindow(user);
        window.window();
    }

    private String usernameCheck(Scanner scanner, List<User> usersList) {
        while (true) {
            System.out.println("Sukurkite vartotojo vardą:");
            String userName = scanner.nextLine();

            boolean userNameAlreadyExists = usersList.stream()
                    .anyMatch(u -> u.getUsername().equals(userName));

            if (userNameAlreadyExists) {
                System.out.println("Toks vartotojo vardas jau egzistuoja.\n");
                continue;
            }
            return userName;
        }
    }

    private boolean passwordCheck(Scanner scanner, String password) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Pakartokite slaptažodžio įvedimą:");
            String repeatPassword = scanner.nextLine();
            if (!repeatPassword.equals(password)) {
                System.out.println("Slaptažodžiai nesutampa.\n");
                continue;
            }
            return true;
        }
        return false;
    }
}

