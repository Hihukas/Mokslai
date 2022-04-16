package LocalDateTime;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Įveskite laiką:");
        Scanner scanner = new Scanner(System.in);
        String enteredTime = scanner.next();
        scanner.close();
        LocalTime time = LocalTime.parse(enteredTime, timeFormat);
        System.out.println("Įvestas laikas: " + time);
        LocalTime time2 = LocalTime.from(time);
        LocalTime time3 = time2.plusHours(2).plusMinutes(15);
        System.out.println(time3);
        int timeCompare = time2.compareTo(LocalTime.now());
        if (timeCompare == 0) {
            System.out.println("Laikas sutampa.");

        } else if (timeCompare < 0) {
            System.out.println("Įvestas laikas ankstesnis");

        } else {
            System.out.println("Įvestas laikas vėlesnis");
        }
    }
}