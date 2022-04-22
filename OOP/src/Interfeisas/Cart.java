package Interfeisas;

public interface Cart extends Cart2{

    void printCartInfo();
    double getCartAmount();
    default void testDefault(){
        System.out.println("Interface default method");
    }
}
