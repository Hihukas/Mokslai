package lt.codeacademy;

import java.util.Scanner;

public class Utility {
    private Scanner scanner = new Scanner(System.in);

    public Utility() {
    }

    public Utility(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
