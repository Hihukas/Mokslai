package Failai;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferedWriterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite, ką norite įrašyti: ");
        String input = scanner.nextLine();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt", true))) {
            bufferedWriter.write(input);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
