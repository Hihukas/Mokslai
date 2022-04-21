package AbstraktiKlase;

public class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("Loja");
    }

    @Override
    public int getAge() {
        return 10;
    }
}
