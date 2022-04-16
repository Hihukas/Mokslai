package LocalDateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.minusHours(3).plusDays(5).format(DateTimeFormatter.ofPattern("yyyy MM dd HH:mm")));
    }
}
