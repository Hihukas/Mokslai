package lt.codeacademy.LanguageDetector;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;

import java.util.Scanner;

public class Main {
    private static final int MAX = 10;
    public static void main(String[] args) {
        LanguageDetector languageDetector = LanguageDetectorBuilder.fromAllLanguages().build();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < MAX; i++){
            System.out.println("Įveskite žodį ar sakinį:");
            String text = scanner.nextLine();
            Language language = languageDetector.detectLanguageOf(text);

            System.out.printf("Įvestas tekstas yra %s kalbos\n", language.name());
        }
    }
}
