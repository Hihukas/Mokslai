package lt.codeacademy.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class TaskOne2 {
    public static void main(String[] args) {
        List<String> first = new ArrayList<>();
        first.add("Mama");
        first.add("Tėtis");
        List<String> second = new ArrayList<>();
        second.add("Brolis");
        second.add("Sesuo");

        BiFunction<List<String>, List<String>,List<String>> method = (list1, list2) ->{
            List<String> third = new ArrayList<>();
            third.addAll(first);
            third.addAll(second);
            Collections.sort(third);
            return third;
        };

        List<String> newList = method.apply(first, second);
        System.out.println(newList);


    }
}
