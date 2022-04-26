package lt.codeacademy.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskOne {
    public static void main(String[] args) {
        List<String> first = new ArrayList<>();
        first.add("A");
        first.add("B");
        first.add("C");
        first.add("D");
        first.add("E");
        List<String> second = new ArrayList<>();
        second.add("F");
        second.add("O");
        second.add("V");
        second.add("Q");
        second.add("N");

        BiFunction<List<String>, List<String>, List<String>> newList = (list1, list2) -> {
            List<String> third = new ArrayList<>();
            third.addAll(first);
            third.addAll(second);
            Collections.sort(third);
            return third;
        };

        System.out.println(newList.apply(first, second));

        BiFunction<List<String>, List<String>, List<String>> newList2 = (list1, list2) ->
                Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());


        System.out.println(newList2.apply(first, second));

        BiFunction<List<String>, List<String>, List<String>> newList3 = (list1, list2)
                -> List.of(list1, list2).stream().flatMap(Collection::stream).sorted().collect(Collectors.toList());

    }

}



