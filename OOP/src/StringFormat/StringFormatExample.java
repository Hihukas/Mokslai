package StringFormat;

public class StringFormatExample {
    public static void main(String[] args) {
        String name = "Aleksandras";
        String surname = "Dudėnas";
        int birth = 1990;
        float height = 1.75f;
        System.out.printf("Asmens, %s %s, gimusio %d m., ūgis yra %.2f m.", name, surname, birth, height);
    }
}
