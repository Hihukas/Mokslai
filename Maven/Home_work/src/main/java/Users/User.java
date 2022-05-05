package Users;

import java.util.UUID;

public class User {

    private final Title title;
    private final UUID id;
    private final String name;
    private final String surname;

    public User(Title title, UUID id, String name, String surname) {
        this.title = title;
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Title getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Users.User{" +
                "title=" + title +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
