package lt.codeacademy.function;

import java.util.function.Function;

public class MultipleFunction {
    public static void main(String[] args) {



        Function<String, Function<String, String>> multipleFunction = value -> {
            Function<String, String> otherFunction = value2 -> value + " " + value2;
            return otherFunction;
        };

        String result = multipleFunction.apply("Pirmas").apply("Antras");
    }
}
