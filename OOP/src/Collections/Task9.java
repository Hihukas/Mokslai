package Collections;

import java.util.HashMap;
import java.util.Map;

public class Task9 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(11, "Vienuolika");
        map.put(12, "Dvylika");
        map.put(100, "Šimtas");
        System.out.println(map);
        System.out.printf("%s - %s\n", map.containsKey(12), map.containsValue("Dvylika"));
        System.out.println(map.get(100));
        for (Integer key : map.keySet()) {
            System.out.printf("Raktas: %s, Reikšmė: %s\n", key, map.get(key));
        }
    }
}
