package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Exams.ExamType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class ExamsCreateWindow extends AbstractWindow {
    public void window() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });

        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();


        System.out.println("Įveskite egzamino temą:");
        String examTheme = scanner.nextLine();
        System.out.println("Įveskite norimą klausimų kiekį:");
        int examQuestionsQuantity = scanner.nextInt();


        for (int i = 0; i <= examQuestionsQuantity; i++) {
            System.out.println("Sukurkite klausimą:");
            String questionCreate = scanner.nextLine();
            questions.add(questionCreate);
            System.out.println("Įveskite norimą atsakymų kiekį:");
            int examQuestionsAnswersQuantity = scanner.nextInt();
            for(int a = 0; a <= examQuestionsAnswersQuantity; a++){
                System.out.println("Įrašykite atsakymą:");
                String answerCreate = scanner.nextLine();
                answers.add(answerCreate);
            }
            System.out.println("Nurodykite teisingą atsakymą:");
            int correctAnswer = scanner.nextInt();
        }

        questions.forEach(System.out::println);

//       exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, examTheme, new ArrayList<>(questions)))
    }
}

