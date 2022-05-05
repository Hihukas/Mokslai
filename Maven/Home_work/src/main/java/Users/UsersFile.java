package Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class UsersFile {
    public void usersFileCreate() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        UsersList usersList = new UsersList();

        File file = new File("Users.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        objectMapper.writeValue(file, usersList.usersList());
    }
}

