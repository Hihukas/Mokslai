package lt.codeacademy.json.example.Json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomPersonSerializer extends StdSerializer<Person> {

    protected CustomPersonSerializer() {
        super(Person.class);
    }

    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("name1", person.getName());
        jsonGenerator.writeStringField("surname2", person.getSurname());
        jsonGenerator.writeNumberField("age3", person.getAge());

        jsonGenerator.writeEndObject();
    }
}
