package AbstraktiKlase;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.printInfo();

        Animal animal = new Cat();
        animal.sound();

       /* Animal animal1 = new Animal() {
            @Override
            public void sound() {
                System.out.println("Inline");
            }
        };

        animal1.sound();*/
    }
}
