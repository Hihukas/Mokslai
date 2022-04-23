package Failai;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objectOutput.txt"))) {
            objectOutputStream.writeObject(new Person("Andrius", 55));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
