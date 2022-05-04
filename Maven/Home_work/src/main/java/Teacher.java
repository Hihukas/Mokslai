public class Teacher {
    private Title title;
    private String name = "Vardenis";
    private String surname = "Pavardenis";

    public Teacher() {
    }

    public Teacher(Title title, int id, String name, String surname) {
        this.title = title;
        this.name = name;
        this.surname = surname;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "title=" + title +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
