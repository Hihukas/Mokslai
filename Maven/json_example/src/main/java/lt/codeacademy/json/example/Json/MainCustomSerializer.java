package lt.codeacademy.json.example.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MainCustomSerializer {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Person.class, new CustomPersonSerializer());

        mapper.registerModule(module);

        Person person = new Person("Andrius", "Balt", 55, null);
        String value = mapper.writeValueAsString(person);
        System.out.println(value);
    }
}
