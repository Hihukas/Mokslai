package JAR.Task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Įveskite savo vardą:\n");
        String name = scanner.nextLine();
        System.out.printf("Įveskite savo pavardę:\n");
        String surname = scanner.nextLine();
        System.out.printf("Jūsų vardas: %s\nJūsų pavardė: %s\n", name, surname);

    }


}
