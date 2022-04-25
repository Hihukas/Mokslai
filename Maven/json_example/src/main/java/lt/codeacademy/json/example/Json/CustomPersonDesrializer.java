package lt.codeacademy.json.example.Json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomPersonDesrializer extends StdDeserializer<Person> {


    protected CustomPersonDesrializer() {
        super(Person.class);
    }

    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        Person person = new Person();

        JsonNode treeNode = jsonParser.getCodec().readTree(jsonParser);

        JsonNode node = treeNode.get("name1");
        if (node != null) {
            person.setName(node.asText());
        }

        node = treeNode.get("surname2");
        if (node != null) {
            person.setSurname(node.asText());
        }

        node = treeNode.get("age3");
        if (node != null) {
            person.setAge(node.asInt());
        }

        return person;
    }
}
