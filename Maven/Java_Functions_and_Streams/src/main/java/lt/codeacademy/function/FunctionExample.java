package lt.codeacademy.function;

import java.util.function.*;

public class FunctionExample {
    public static void main(String[] args) {
        FunctionExample example = new FunctionExample();
       //Supplier <Integer> supplier = () -> 50; nereikia laužtinių skliaustų, jei viena eilutė
        Supplier <Integer> supplier = () -> {
            int a = 50;
            return a;
        };
        System.out.println(supplier.get());
        example.testSupplier(supplier);
        example.testSupplier(() -> 60);

        //Skliausteliai nera būtini (value), jei yra vienas parametras
        //Consumer<String> consumer = (value) -> System.out.println(value.toUpperCase());
        Consumer<String> consumer = value -> System.out.println(value.toUpperCase());
        consumer.accept("Andrius");


        Function<Integer, String> function = value -> String.valueOf(value*10);
        String result = function.apply(10);
        System.out.println(result);

        Predicate<String> predicate = value -> value!= null && value.startsWith("test");
        if(predicate.test("testing")){
            System.out.println("Praleidžiam");
        }else{
            System.out.println("Nepavyko");
        }

        BiConsumer<Integer, Integer> biConsumer = (x,y) -> System.out.println(x*y);
        biConsumer.accept(50, 80);

        BiPredicate<String, String> biPredicate = (v1, v2) -> v1 !=null && v1.equals(v2);
        System.out.println(biPredicate.test("a", "a"));

        BiFunction<Integer, Integer, String> biFunction = (x, y) -> String.valueOf(x*y);
        System.out.println(biFunction.apply(50, 10));

        CustomFunctionInterface customFunctionInterface =(v1, v2, v3) -> System.out.println(v1 +v2 +v3);
        customFunctionInterface.doSomething(50, 50, 40);

        example.createFunctionInterface().doSomething(40, 50, 10);
        example.testMyFunctionInterface((a, b, c)-> System.out.println(a/c*b));
        example.testMyFunctionInterface((a, b, c)-> System.out.println(a*c-b));
    }

    public void testSupplier(Supplier<Integer> supplier){
        System.out.println(supplier.get());
    }

    private CustomFunctionInterface createFunctionInterface(){
        return (v1, v2, v3) -> System.out.println(v1 - v2 * v3);
    }

    private void testMyFunctionInterface (CustomFunctionInterface function){
        function.doSomething(50, 70, 80);
    }
}
