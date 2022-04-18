package Collections;

import java.util.HashSet;
import java.util.Set;

public class Task8 {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Aleksandras");
        names.add("Andrius");
        names.add("Saulius");
        System.out.println(names);
        System.out.println(names.size());
        names.add("Aleksandras");
        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("Andrius"));
        if(names.contains("Andrius")){
            names.remove("Andrius");
        }
        System.out.println(names);
        System.out.println(names.size());
        names.clear();
        System.out.println(names);
        System.out.println(names.size());
    }
}
