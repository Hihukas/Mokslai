package LocalDateTime;

import java.time.LocalDate;

public class DatesCompareExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(1990, 6, 15);
        LocalDate date2 = LocalDate.of(1990, 6, 15);
        if (date1.isBefore(date2)) {
            System.out.println("Mano gimtadienis.");
        } else if (date1.isAfter(date2)) {
            System.out.println("Šiandien diena.");
        }
        int compareToExample = date1.compareTo(date2);
        if(compareToExample == 0){
            System.out.println("Abi datos vienodos.");
        } else if (compareToExample > 0) {
            System.out.println("Pirmoji data vėlesnė.");
        } else{
            System.out.println("Antroji data vėlesnė.");
        }
    }
}
