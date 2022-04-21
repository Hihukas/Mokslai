package PaveldejimasInheritance;

public class Student extends Person {
    private final String university;

    public Student(String name, String surname, String personCode, String university) {
        super(name, surname, personCode);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }
}
