package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task11 {
    private final Map<Integer, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Task11 task11 = new Task11();
        Scanner scanner = new Scanner(System.in);
        String action;

        do {
            task11.menu();
            action = scanner.nextLine();
            task11.callAction(action, scanner);
        } while (!action.equals("3"));


    }

    private void callAction(String action, Scanner scanner) {
        switch (action) {
            case "1" -> addStudent(scanner);
            case "2" -> getStudent(scanner);
            case "3" -> System.out.println("Programa baigė darbą");
            default -> System.out.println("Tokio veiksmo nėra");
        }
    }

    private void getStudent(Scanner scanner) {
        System.out.println("Įveskite norimą studento ID:\n");
        int studentId = scanner.nextInt();
        Student student = students.get(studentId);
        scanner.nextLine();

        if (student == null) {
            System.out.printf("Studento su tokiu ID %s nėra\n", studentId);
        } else {
            System.out.println(student);
        }
    }

    private void addStudent(Scanner scanner) {
        int studentId = getUniqueStudentId(scanner);
        System.out.println("Įveskite studento vardą:\n");
        String name = scanner.nextLine();
        System.out.println("Įveskite studento pavardę:\n");
        String surname = scanner.nextLine();
        System.out.println("Įveskite universitetą:\n");
        String university = scanner.nextLine();

        students.put(studentId, new Student(name, surname, university));

    }

    private int getUniqueStudentId(Scanner scanner) {
        int studentId;
        do {
            System.out.println("Įveskite studento ID:\n");
            studentId = Integer.parseInt(scanner.nextLine());
        } while (students.containsKey(studentId));
        return studentId;
    }

    private void menu() {
        System.out.println("""
                [1] Įvesti studentą;
                [2] Gauti studentą pagal numerį;
                [3] Baigti darbą.
                """);
    }
}
