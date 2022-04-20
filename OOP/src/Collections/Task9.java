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

        if(map.containsKey(11) && map.containsValue("Vienuolika")){
            System.out.println("Yra tokia pora.");
        }

        System.out.println(map.get(100));

        Task9 task9 = new Task9();
        task9.printMap(map);

        map.remove(11);
        task9.printMap(map);
        map.clear();
        task9.printMap(map);
    }

    private void printMap(Map<Integer, String> map) {
        for (Integer key : map.keySet()) {
            System.out.printf("Raktas: %s, Reikšmė: %s\n", key, map.get(key));
        }
    }
}
