package PaveldejimasInheritance;

public class MainABC {
    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        System.out.println(c instanceof C);
        System.out.println(c instanceof B);
        System.out.println(b instanceof C);
    }
}
