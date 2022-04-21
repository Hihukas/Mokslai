package AbstraktiKlase;

public class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("Miaukia");
    }

    @Override
    public int getAge() {
        return 12;
    }
}
