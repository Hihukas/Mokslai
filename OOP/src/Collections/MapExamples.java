package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Aleksandras");
        names.put(2, "Petras");
        names.put(3, "Aleksandras");
        names.put(4, "Mama");
        names.put(3, "Ona");

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.isEmpty());
        System.out.println(names.values());
        System.out.println(names.containsKey(4));


        Map<Integer, String> cars = new LinkedHashMap<>();
        cars.put(2, "BMW");
        cars.put(5, "Audi");
        cars.put(6, "VW");
        cars.put(7, "Opel");
        cars.put(1, "Toyota");
        System.out.println(cars);

        Map<Integer, String> cities = new TreeMap<>();
        cities.put(5, "Alytus");
        cities.put(2, "Panevėžys");
        cities.put(15, "Kaunas");
        cities.put(10, "Vilnius");
        System.out.println(cities);


        Map<String, String> names2 = Map.of("k1","v1", "k2", "v2");
        System.out.println(names2.get("k2"));

        for(String key: names2.keySet()){
            System.out.printf("%s-%s\n", key, names2.get(key));
        }
        for(String value: names2.values()){
            System.out.println(value);
        }

        for(Map.Entry<String, String> entry: names2.entrySet()){
            System.out.printf("%s-%s\n", entry.getKey(), entry.getValue());
        }

        Map<String, Person> persons = new HashMap<>();
        persons.put("Andrius", new Person("Andrius", 82));
        persons.put("Petras", new Person("Andrius", 82));
        persons.put("Jonas", new Person("Jonas", 10));
        persons.put("Antanas", new Person("Andrius", 82));
        persons.put("Jokubas", new Person("Andrius", 82));

        System.out.println(persons);

        Map<Person, Integer> persons2 = new HashMap<>();
        persons2.put(new Person("Andrius", 82), 5);
        persons2.put(new Person("Andrius", 82), 10);
        persons2.put(new Person("Jonas", 10), 50);
        persons2.put(new Person("Andrius", 82), 50);
        persons2.put(new Person("Andrius", 82), 55);

        System.out.println(persons2);






    }
}
