import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UsersFile {
    public void usersFileCreate(Map<String, String> users) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Users.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        objectMapper.writeValue(file, users);
    }
}

