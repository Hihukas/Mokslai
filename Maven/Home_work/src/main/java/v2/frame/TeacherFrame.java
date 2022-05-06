package v2.frame;

import java.util.Scanner;

public class TeacherFrame {
    public void print() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Testų rezultatai.
                [2] - Sukurti testą.
                [3] - Testų redagavimas.
                [4] - Išeiti.
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("open tests");
            case "2" -> System.out.println("open tests");
            case "3" -> System.out.println("open tests");
            case "4" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                TeacherFrame frame = new TeacherFrame();
                frame.print();
            }
        }
    }
}

