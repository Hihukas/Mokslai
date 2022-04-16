package LocalDateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeEntryExample {
    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Įveskite laiką:");
        Scanner scanner = new Scanner(System.in);
        String textFromConsole = scanner.next();
        scanner.close();

        LocalTime time = LocalTime.parse(textFromConsole, f);
        System.out.println("Įvestas laikas: "+time);
        System.out.println("Pridėjus vieną valandą bus: " +time.plusHours(1));
    }
}
