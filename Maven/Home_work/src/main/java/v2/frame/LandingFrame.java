package v2.frame;

import java.util.Scanner;

public class LandingFrame {
    public void print() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Prisijungimas.
                [2] - Naujų studentų registracija.
                [3] - Išeiti.
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("open Prisijungimas");
            case "2" -> System.out.println("open Naujų studentų registracija");
            case "3" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                LandingFrame frame = new LandingFrame();
                frame.print();
            }
        }
    }
}


