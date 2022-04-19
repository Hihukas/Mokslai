package JAR;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JarMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        JarMain jarMain = new JarMain();
        jarMain.menu();

        String action = scanner.nextLine();
        jarMain.selecAction(scanner, action, args);


    }

    private void menu() {
        System.out.println("""
                a. sum
                b. minus
                c. multiply
                d. divide
                """);
    }

    private void selecAction(Scanner scanner, String action, String[] args) {
        CalculatorService calculatorService = new CalculatorService();

        int a = getCorrectNumber(args.length > 0 ? args[0] : null, scanner);
        int b = getCorrectNumber(args.length > 1 ? args[1] : null, scanner);

        switch (action) {
            case "a" -> System.out.printf("Suma yra: %s\n", calculatorService.sum(a, b));
            case "b" -> System.out.printf("Skirtumas yra: %s\n", calculatorService.minus(a, b));
            case "c" -> System.out.printf("Daugybos rezultatas yra: %s\n", calculatorService.multiply(a, b));
            case "d" -> {
                try {
                    int result = calculatorService.divide(a, b);
                    System.out.printf("Dalybos rezultatas yra: %s\n", result);
                } catch (ArithmeticException e) {
                    System.out.println("Dalyba iš nulio negalima.");
                }
            }
            default -> System.out.println("Nėra tokio veiksmo.");
        }

    }

    private int getCorrectNumber(String value, Scanner scanner) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
        }

        while (true) {
            try {
                System.out.println("Įveskite skaičių:");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Blogas formatas.");
                scanner.nextLine();
            }
        }
    }
}
