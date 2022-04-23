package Failai;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {
    public static void main(String[] args) {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objectOutput.txt"))) {
           Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
