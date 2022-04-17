package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> texts = List.of("Mama", "Petras", "Klaipėda");
        String text = "";
        for (String t : texts) {
            if (t.length() > text.length()) {
                text = t;
            }

        }
        System.out.println(text);

        List<String> names = new ArrayList<>();
        names.add("Mama");
        names.add("Petras");
        names.add("Klaipėda");
        names.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return 0;
            }
            return o1.length() > o2.length() ? -1 : 1;
        });
        System.out.println(names.get(0));
    }


}

