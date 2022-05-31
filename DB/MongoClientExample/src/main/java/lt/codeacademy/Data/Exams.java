package lt.codeacademy.Data;

import org.bson.types.ObjectId;

//public record Exams(ObjectId id, String name, String surname, Integer pazymys) {
//}

public class Exams{

    private ObjectId id;
    private String name;
    private String surname;
//    private int pazymys;

    public Exams() {
    }

    public Exams(ObjectId id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
//        this.pazymys = pazymys;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public int getPazymys() {
//        return pazymys;
//    }
//
//    public void setPazymys(int pazymys) {
//        this.pazymys = pazymys;
//    }

    @Override
    public String toString() {
        return "Exams{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
//                ", pazymys=" + pazymys +
                '}';
    }
}
