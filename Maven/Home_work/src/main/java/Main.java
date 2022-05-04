import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> users = new HashMap<>();
        Map<Title, Teacher> teacher = new HashMap<>();
        teacher.put(Title.TEACHER, new Teacher());
        UsersFile usersFile = new UsersFile();
        Menu menu = new MainMenu();
        menu.menu(scanner, users);
        usersFile.usersFileCreate(teacher);
    }
}
