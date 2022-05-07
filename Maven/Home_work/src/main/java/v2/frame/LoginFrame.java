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
    public void print() throws IOException, InterruptedException {
//        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite vartotojo vardą: ");
        String userName = scanner.nextLine();
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();
        User user = login(userName, password);
        switch (user.getUserType()) {
            case STUDENT -> {
                System.out.println("Sveikiname prisijungus!");
                StudentFrame frame = new StudentFrame();
                frame.print();
            }
            case TEACHER -> {
                System.out.println("Sveikiname prisijungus!");
                TeacherFrame frame = new TeacherFrame();
                frame.print();
            }
            default -> {
                System.out.println("Neteisingas vartotojo vardas arba slaptažodis. Bandykite dar kartą.");
                LoginFrame frame = new LoginFrame();
                frame.print();
            }
        }
    }

    public User login(String userName, String password) throws IOException {
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



