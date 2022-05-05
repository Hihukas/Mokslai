import Users.UsersFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new MainMenu();
        UsersFile usersFile = new UsersFile();
        usersFile.usersFileCreate();

    }
}
