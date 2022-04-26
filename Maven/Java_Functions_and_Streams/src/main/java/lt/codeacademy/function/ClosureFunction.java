package lt.codeacademy.function;

import java.util.function.IntSupplier;

public class ClosureFunction {
    private int count = 0;

    public IntSupplier supply(int value){
        return () -> value + ++count;
    }

    public static void main(String[] args) {
        ClosureFunction function = new ClosureFunction();

        IntSupplier supplier = function.supply(55);
        IntSupplier supplier1 = function.supply(22);
        IntSupplier supplier2 = function.supply(97);

        System.out.println(supplier.getAsInt());
        System.out.println(supplier1.getAsInt());
        System.out.println(supplier2.getAsInt());

    }
}
