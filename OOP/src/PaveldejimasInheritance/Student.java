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

    @Override
    public String getPersonCode() {
        String code = super.getPersonCode();
        return code.substring(0, code.length() / 2);
    }

    @Override
    public String printInfo() {
        return String.format("Universitetas: %s", university);
    }
}
