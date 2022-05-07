package v2.frame;

import Exams.Exam;
import Exams.ExamType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class ExamCreateFrame {
    public void print() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });
        System.out.println("Įveskite egzamino temą:");
        String examTheme = scanner.nextLine();
        System.out.println("Įveskite norimą klausimų kiekį:");
        int examQuestionsQuantity = scanner.nextInt();

        List<String> questions = new ArrayList<>();

        for (int i = 0; i < examQuestionsQuantity; i++) {
            String questionCreate = scanner.nextLine();
            System.out.println("Sukurkite klausimą:");
            questions.add(questionCreate);
        }

        questions.forEach(System.out::println);

//        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, examTheme, ))
    }
}

