package Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task10 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(11, "Vienuolika");
        map.put(12, "Dvylika");
        map.put(100, "Šimtas");

        Task10 task10 = new Task10();
        task10.map2(map);
    }

    private void map2(Map<Integer, String> map) {
        Map<String, Integer> map2 = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }

        for (String key2 : map2.keySet()) {
            System.out.printf("Raktas: %s, Reikšmė: %s\n", key2, map2.get(key2));

        }
    }

}

