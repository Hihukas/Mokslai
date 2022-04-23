package Failai;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputStreamExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite, ką norite įrašyti: ");
        String line = scanner.nextLine();

        File file = new File("output.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (int i = 0; i < line.length(); i++) {
                fileOutputStream.write(line.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
