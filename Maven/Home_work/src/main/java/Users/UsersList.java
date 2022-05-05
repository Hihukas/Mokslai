package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersList {
    public List<User> usersList(){
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(Title.TEACHER, UUID.randomUUID(), "Vardenis", "Pavardenis"));
        usersList.add(new User(Title.STUDENT, UUID.randomUUID(), "aaa", "bbbb"));
        return usersList;
    }
}
