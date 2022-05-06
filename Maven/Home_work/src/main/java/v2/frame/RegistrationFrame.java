package v2.frame;

import Users.User;
import Users.UserType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RegistrationFrame {
    public void print() throws IOException {
        Scanner scanner = new Scanner(System.in);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Users.json");

        List<User> usersList = objectMapper.readValue(file, new TypeReference<>() {});

        RegistrationFrame registrationFrame = new RegistrationFrame();

        String userName = registrationFrame.usernameCheck(scanner, file, objectMapper, usersList);
        System.out.println("Sukurkite slaptažodį:");
        String password = scanner.nextLine();
        if (!passwordCheck(scanner, password)) {
            System.out.println("Paskyros sukurti nepavyko.");
            return;
        }
        System.out.println("Įveskite savo vardą:");
        String name = scanner.nextLine();
        System.out.println("Įveskite savo pavardę:");
        String surname = scanner.nextLine();

        usersList.add(new User(UUID.randomUUID(), UserType.STUDENT, userName, password, name, surname));
        objectMapper.writeValue(file, usersList);

        switch (UserType.STUDENT) {
            case STUDENT -> {
                System.out.println("open Student View");
            }
            default -> {
                System.out.println("Prisijungti nepavyko.");
                RegistrationFrame frame = new RegistrationFrame();
                frame.print();
            }
        }
    }

    private String usernameCheck(Scanner scanner, File file, ObjectMapper objectMapper, List<User> usersList) throws IOException {
        while (true) {
            System.out.println("Sukurkite vartotojo vardą:");
            String userName = scanner.nextLine();

            boolean userNameAlreadyExists = usersList.stream().anyMatch(u -> u.getUsername().equals(userName));

            if (userNameAlreadyExists) {
                System.out.println("Toks vartotojo vardas jau egzistuoja.");
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
                System.out.println("Slaptažodžiai nesutampa.");
                continue;
            }
            return true;
        }
        return false;
    }
}

