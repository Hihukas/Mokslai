package lt.codeacademy.Windows;

import java.util.Scanner;

public class TeacherWindow extends AbstractWindow {


    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Pasirinkite norimą atlikti veiksmą:
                [1] - Egzaminų rezultatai.
                [2] - Sukurti egzaminą.
                [3] - Egzaminų redagavimas.
                [4] - Išeiti.
                """);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> System.out.println("open tests");
            case "2" -> System.out.println("open tests");
            case "3" -> {
                ExamsWindow frame = new ExamsWindow();
                frame.window();
            }
            case "4" -> System.out.println("Programa baigia darbą.");
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                TeacherWindow frame = new TeacherWindow();
                frame.window();
            }
        }
    }
}

