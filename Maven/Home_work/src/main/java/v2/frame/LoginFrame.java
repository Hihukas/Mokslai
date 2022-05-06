package v2.frame;

import Users.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoginFrame {
    public void print() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Sveikiname prisijungę prie sistemos!
                                
                Įveskite vartotojo vardą:
                """);
        String userName = scanner.nextLine();
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();
        User user = login(userName, password);
        switch (user.getUserType()) {
            case STUDENT -> {
                System.out.println("open Student View");
            }
            case TEACHER -> {
                System.out.println("open lector View");
            }
            default -> {
                System.out.println("wrong login name try again");
                LoginFrame frame = new LoginFrame();
                frame.print();
            }
        }
    }

    public User login(String userName, String password) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Users.json");
        List<User> usersList = objectMapper.readValue(file, new TypeReference<>() {});

        return usersList.stream()
                .filter(u -> u.getUsername().equals(userName) && u.getPassword().equals(password))
                .findAny()
                .orElse(null);
    }
}



