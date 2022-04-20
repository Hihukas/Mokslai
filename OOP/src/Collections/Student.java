package Collections;

public class Student {
    private final String name;
    private final String surname;
    private  final String university;

    public Student(String name, String surname, String university) {
        this.name = name;
        this.surname = surname;
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
