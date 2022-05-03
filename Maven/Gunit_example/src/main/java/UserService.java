import java.util.UUID;

public class UserService {

    public String getUsername(){
        return "dummyUserName";
    }

    public User getUserById(UUID id){
        return new User(5);
    }
}
