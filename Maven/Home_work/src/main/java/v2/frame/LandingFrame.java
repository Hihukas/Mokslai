package v2.frame;

import java.io.IOException;
import java.util.Scanner;

public class LandingFrame {
    public void print() throws IOException, InterruptedException {
        //       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Prisijungimas.
                [2] - Naujų studentų registracija.
                [3] - Išeiti.
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                LoginFrame frame = new LoginFrame();
                frame.print();
            }
            case "2" -> {
                RegistrationFrame frame = new RegistrationFrame();
                frame.print();
            }
            case "3" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                LandingFrame frame = new LandingFrame();
                frame.print();
            }
        }
    }
}


