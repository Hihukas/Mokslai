package v2.frame;

import java.util.Scanner;

public class StudentFrame {
    public void print(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Laikyti testą.
                    [2] - Testų rezultatai.
                    [3] - Išeiti.
                    """);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("open tests");
            case "2" -> System.out.println("open results");
            case "3" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                StudentFrame frame = new StudentFrame();
                frame.print();
            }
        }
    }
}
