package PaveldejimasInheritance;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Andrius","Pavardė", "33333333", "KTU");
        student.getName();
        System.out.println(student.getUniversity());
    }
}
