package lt.codeacademy.generic;
//
public class Calculator <T extends Number>{
    private final T t1;
    private final T t2;

    public Calculator(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public Number sum(){
       return t1.doubleValue() + t2.doubleValue();
    }
}
