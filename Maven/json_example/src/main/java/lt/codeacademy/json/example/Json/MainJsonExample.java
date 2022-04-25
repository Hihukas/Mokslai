package lt.codeacademy.json.example.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class MainJsonExample {
    public static void main(String[] args) throws IOException {
        // Reikalingas Json serializable ir desrializable objektams
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Suformatuoja į Json kalbą

        File file = new File("persons.json");
        if(!file.exists()){
            file.createNewFile();
        }

        Person person = new Person("Andrius", "Baltrūnas", 33, new Address("Kaunas", "LT", "Savanorių pr."));
        mapper.writeValue(file, person);

        person = mapper.readValue(file, Person.class);
        System.out.println(person);
    }
}
