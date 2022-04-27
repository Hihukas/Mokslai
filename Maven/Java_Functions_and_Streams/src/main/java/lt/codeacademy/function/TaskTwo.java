package lt.codeacademy.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Andrius");
        names.add("Jonas");
        names.add("Petras");
        names.add("Jokubas");
        names.add("Jonas");
        TaskTwo taskTwo = new TaskTwo();
        taskTwo.methodOne(taskTwo.sortNames(), names);
        taskTwo.methodOne(taskTwo.upperCaseNames(), names);
    }

    private void methodOne(Function<List<String>, List<String>> function, List<String> names) {
        names = function.apply(names);
        names.forEach(System.out::println);
    }

    private Function<List<String>, List<String>> sortNames() {
        return names -> {
            Collections.sort(names);
            return names;
        };
    }

    private Function<List<String>, List<String>> upperCaseNames() {
       return names -> {
         List<String> newArray = new ArrayList<>();
          for(String name: names){
              newArray.add(name.toUpperCase());
          }
          return newArray;
        };
       // return names -> names.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
