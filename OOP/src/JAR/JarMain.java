package JAR;

public class JarMain {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();

        if (args.length < 2) {
            System.out.println("Nėra parametrų.");
            return;
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.printf("Suma yra: %s\n", calculatorService.sum(a, b));
    }
}
