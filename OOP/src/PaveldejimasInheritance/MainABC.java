package PaveldejimasInheritance;

public class MainABC {
    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        A c1 = new C();
        System.out.println(c instanceof C);
        System.out.println(c instanceof B);
        System.out.println(b instanceof C);

        System.out.println(c.id);
        System.out.println(b.id);
        System.out.println(c1.id);
    }
}
