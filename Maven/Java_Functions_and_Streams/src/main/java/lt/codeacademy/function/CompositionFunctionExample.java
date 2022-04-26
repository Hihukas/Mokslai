package lt.codeacademy.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionFunctionExample {
    public static void main(String[] args) {
        Function<String, String> function = value -> value.substring(7),
                function1 = value -> value.replace("s", "$"),
                function2 = String::toUpperCase,
                function3 = function.compose(function1).andThen(function2);

        String result = function3.apply("Einu namo, nes labai šalta");
        System.out.println(result);

        Predicate<String> p = v -> v.contains("@"),
                p1 = v -> v.length() >= 10,
                p2 = v -> v.endsWith(".com"),
                p3 = p.and(p1).and(p2);

        System.out.println(p3.test("andriusbaltrunasgmail.com"));//false
        System.out.println(p3.test("andriusbaltrunas@gmail.com"));//true
        System.out.println(p3.test("a@a.com"));//false
    }
}
