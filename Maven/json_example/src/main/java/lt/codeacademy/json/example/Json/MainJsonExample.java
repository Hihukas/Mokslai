package lt.codeacademy.json.example.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainJsonExample {
    public static void main(String[] args) throws IOException {
        // Reikalingas Json serializable ir desrializable objektams
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Suformatuoja į Json kalbą

        File file = new File("persons.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        Person person = new Person("Andrius", "Baltrūnas", 33, new Address("Vilnius", "LT", "Savanorių pr."));
        Person secondPerson = new Person("Aleksandras", "Dudėnas", 31, new Address("Klaipėda", "LT", "Turgaus a."));
        mapper.writeValue(file, person);

        person = mapper.readValue(file, Person.class);
        System.out.println(person);

        String personAssString = mapper.writeValueAsString(person);
        System.out.println(personAssString);

        person = mapper.readValue(personAssString, Person.class);
        System.out.println(person);

        List<Person> persons = List.of(person, secondPerson, person);
        mapper.writeValue(file, persons);

        persons = mapper.readValue(file, new TypeReference<>() {});
        persons.forEach(System.out::println);


    }
}
