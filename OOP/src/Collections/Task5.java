package Collections;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Task5 task5 = new Task5();
        Scanner scanner = new Scanner(System.in);
        String action;

        List<String> list = new ArrayList<>();
        do {
            task5.showMenu();
            action = scanner.nextLine();
            task5.callAction(scanner, action, list);
        } while (!action.equals("6"));

    }

    private void showMenu() {
        System.out.println("""
                1 - Įvesti žodį.
                2 - Rasti žodį.
                3 - Trinti žodį.
                4 - Išvalyti sąrašą.
                5 - Atspausdinti sąrašą.
                6 - Baigti programą.
                """
        );
    }

    private void callAction(Scanner scanner, String action, List<String> list) {
        switch (action) {
            case "1" -> addWord(scanner, list);
            case "2" -> findWord(scanner, list);
            case "3" -> deleteWord(scanner, list);
            case "4" -> clearList(list);
            case "5" -> printoutList(list);
            case "6" -> System.out.println("Programa baigia darbą.");
            default -> System.out.println("Tokio veiksmo nėra.");
        }
    }

    private void printoutList(List<String> list) {
        System.out.println(list);
    }

    private void clearList(List<String> list) {
        list.clear();

    }

    private void deleteWord(Scanner scanner, List<String> list) {
        System.out.println("Įveskite norimą ištrinti žodį:");
        String word = scanner.nextLine();
        if (list.contains(word)) {
            list.remove(word);
        }
    }


    private void findWord(Scanner scanner, List<String> list) {
        System.out.println("Įveskite norimą surasti žod:");
        String word = scanner.nextLine();
        if (list.contains(word)) {
            System.out.println("Toks žodis yra sąraše.");
        } else {
            System.out.println("Tokio žodžio nėra sąraše.");
        }
    }

    private void addWord(Scanner scanner, List<String> list) {
        System.out.println("Įveskite norimą žodį:");
        list.add(scanner.nextLine());
    }
}
