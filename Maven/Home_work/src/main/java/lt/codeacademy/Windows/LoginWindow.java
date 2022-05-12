package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class LoginWindow extends AbstractWindow {
    @Override
    public void window() throws Exception {
        User user;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Įveskite vartotojo vardą: ");
            String userName = scanner.nextLine();
            System.out.println("Įveskite slaptažodį:");
            String password = scanner.nextLine();

            user = login(userName, password);
            if (user == null) {
                System.out.println("Tokio vartotojo vardo arba slaptažodžio nėra. Bandykite iš naujo.\n");
                window();
            }

            Enum<UserType> userType = user.getUserType();

            switch (user.getUserType()) {
                case STUDENT -> {
                    System.out.println("\nSveikiname prisijungus, studente!\n");
                    StudentWindow studentWindow = new StudentWindow(userType, user);
                    studentWindow.window();
                }
                case LECTOR -> {
                    System.out.println("\nSveikiname prisijungus, dėstytojau!\n");
                    TeacherWindow teacherWindow = new TeacherWindow(userType, user);
                    teacherWindow.window();
                }
                default -> {
                    System.out.println("Neteisingas vartotojo vardas arba slaptažodis. Bandykite dar kartą.\n");
                }
            }
        } while (user.getUserType().equals(UserType.STUDENT) || user.getUserType().equals(UserType.LECTOR));
    }

    public User login(String userName, String password) throws Exception {
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



