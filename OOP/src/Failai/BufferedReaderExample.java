package Failai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("example.txt"))) {
           String line;
           while((line = bufferedReader.readLine()) != null) {
               System.out.println(line);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
