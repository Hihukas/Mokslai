package Interfeisas;

public class ShoppingCart implements Cart, Cart2{
    @Override
    public void printCartInfo() {
        System.out.println("Cart info");
    }

    @Override
    public double getCartAmount() {
        return 22.5;
    }

    @Override
    public void testDefault() {
        System.out.println("Cart default");
    }

    public void testMethod(){
        System.out.println("Method");
    }

    @Override
    public void secondCartMethod() {

    }
}
