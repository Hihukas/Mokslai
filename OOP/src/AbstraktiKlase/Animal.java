package AbstraktiKlase;

public abstract class Animal {

    public abstract void sound();

    public abstract int getAge();

    public void testMethod(){
        System.out.println("This is simple method.");
    }

    public void printInfo(){
        System.out.printf("Gyvūno amžius yra: %s\n", getAge());
    }
}
