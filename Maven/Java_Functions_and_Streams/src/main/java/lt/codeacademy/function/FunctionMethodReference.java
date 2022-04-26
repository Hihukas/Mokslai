package lt.codeacademy.function;

@FunctionalInterface
interface MyFunction{
    String sayHi(String value);
    default String secondMethod(int a){
        return String.valueOf(a);
    };
}

interface MyNonFunction{
    String sayHi(String value);
    //String secondMethod(int a);
}

public class FunctionMethodReference {

    private String myMethod(String value){
        return "Labas " + value;
    }

    public static void main(String[] args) {
        FunctionMethodReference reference = new FunctionMethodReference();

        MyFunction mf = reference::myMethod;
        MyNonFunction nf = reference::myMethod;

        MyFunction secondMf = value -> "Second function" + value;
        MyNonFunction secondNf = value -> "Second not function" + value;

        System.out.println(mf.sayHi("Andrius"));
        System.out.println(nf.sayHi("Petras"));
        System.out.println(secondMf.sayHi(" Jonas"));
        System.out.println(secondNf.sayHi(" Ona"));
    }
}
