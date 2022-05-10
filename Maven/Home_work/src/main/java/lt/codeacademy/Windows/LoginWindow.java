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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Įveskite vartotojo vardą: ");
        String userName = scanner.nextLine();
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();

        User user = login(userName, password);
        Enum<UserType> userType = user.getUserType();


        switch (user.getUserType()) {
            case STUDENT -> {
                System.out.println("\nSveikiname prisijungus, studente!\n");
                StudentWindow studentWindow = new StudentWindow(userType);
                studentWindow.window();
            }
            case LECTOR -> {
                System.out.println("\nSveikiname prisijungus, dėstytojau!\n");
                TeacherWindow teacherWindow = new TeacherWindow(userType);
                teacherWindow.window();
            }
            default -> {
                System.out.println("Neteisingas vartotojo vardas arba slaptažodis. Bandykite dar kartą.");
                LoginWindow frame = new LoginWindow();
                frame.window();
            }
        }
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



