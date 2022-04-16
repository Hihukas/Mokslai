package LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExamples {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(time.getDayOfMonth());
        System.out.println(time.getHour());
        System.out.println(time.getMonth());
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalTime hour = LocalTime.now();
        System.out.println(hour);
        System.out.println(time.plusDays(5));
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy?dd?MM")));

    }
}
