package Failai;

import java.io.*;

public class BufferedReaderExample {



    public static void main(String[] args) {
        String text = """
                ID Name Surname
                1 Andrius Baltrunas
                2 Jonas Jonaitis
                
                
                """;

        /*try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes())))) {
           String line;
           while((line = bufferedReader.readLine() != null)) {
               System.out.println(line);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
