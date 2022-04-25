package lt.codeacademy.json.example.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MainCustomDesirializer {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Person.class, new CustomPersonDesrializer());

        mapper.registerModule(module);

       Person person = mapper.readValue("{\"name1\":\"Andrius\",\"surname2\":\"Balt\",\"age3\":55}", Person.class);
        System.out.println(person);
    }
}
