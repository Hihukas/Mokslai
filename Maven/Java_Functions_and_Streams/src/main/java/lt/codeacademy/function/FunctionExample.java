package lt.codeacademy.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    }

    public void testSupplier(Supplier<Integer> supplier){
        System.out.println(supplier.get());
    }
}
