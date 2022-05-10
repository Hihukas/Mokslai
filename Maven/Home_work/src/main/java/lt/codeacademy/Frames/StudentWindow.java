package lt.codeacademy.Frames;

import java.util.Scanner;

public class StudentWindow extends AbstractWindow {
    @Override
    public void window() throws Exception {
        String input;
        do {
            System.out.println("""
                    Pasirinkite norimą atlikti veiksmą:
                    [1] - Laikyti egzaminą.
                    [2] - Egzaminų rezultatai.
                    [3] - Išeiti.
                    """);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    ExamsWindow examsWindow = new ExamsWindow();
                    examsWindow.window();
                }
                case "2" -> System.out.println("open results");
                case "3" -> System.out.println("Programa baigia darbą.");
                default -> {
                    System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                    StudentWindow frame = new StudentWindow();
                    frame.window();
                }
            }
        } while (!(input.equals("1") || input.equals("2") || input.equals("3")));
    }
}
