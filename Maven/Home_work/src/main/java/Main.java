import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> users = new HashMap<>();
        UsersFile usersFile = new UsersFile();
        Menu menu = new MainMenu();
        menu.menu(scanner, users);
        usersFile.usersFileCreate(users);
    }
}
