package lt.codeacademy.json.example.Task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.json.example.Json.Person;

import java.io.*;

public class FirstTaskMain {
    public static void main(String[] args) throws IOException {
        //  FirstTaskMain firstTaskMain = new FirstTaskMain();
        //firstTaskMain.serializePerson();
        // firstTaskMain.deserializePerson();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("person.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        Payment payment = new Payment(new Sender("Antanas", "Antanaitis"), new Receiver("Jonas", "Jonaitis"));

        // Payment payment = new Payment(new Sender("Aleksandras", "Dudėnas"), new Receiver("Mindaugas", "Šimkevičius"));
        mapper.writeValue(file, payment);

        payment = mapper.readValue(file, Payment.class);
        System.out.println(payment);

        String personAssString = mapper.writeValueAsString(payment);
        System.out.println(personAssString);

        payment = mapper.readValue(personAssString, Payment.class);
        System.out.println(payment);

        // payment = mapper.readValue(file, Payment.class);
        // System.out.println(payment);
    }

    /*private void serializePerson() {
        try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            ob.writeObject(new Payment(new Sender("Jonas", "Jonaitis"), new Receiver("Andrius", "Baltrūnas")));
            ob.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deserializePerson() {
        try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Object o = ob.readObject();
            if (o instanceof Payment payment) {
                System.out.println(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
