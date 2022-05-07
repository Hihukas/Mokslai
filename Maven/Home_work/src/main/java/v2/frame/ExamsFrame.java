package v2.frame;

import Exams.Exam;
import Exams.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ExamsFrame {
    public void print() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });
        System.out.println("Pasirinkite egzaminą:");

        IntStream.range(0, exams.size())
                .mapToObj(i -> {
                    Exam e = exams.get(i);
                    return (i + 1) + ". Egzamino ID: " + e.getId() + ", Egzamino pavadinimas: " + e.getName() + ", Egzamino tipas: " + e.getExamType();
                })
                .forEach(System.out::println);

        Exam exam = exams.get(scanner.nextInt() - 1);

        System.out.printf("Egzaminas:\nID: %s\nTipas: %s\nPavadinimas: %s\n", exam.getId(), exam.getExamType(), exam.getName());


//        IntStream.range(0, questions.size()).mapToObj(a -> {
//            Question q = questions.get(a);
//            return ("\n" + q.getQuestion() + "\n" + q.getAnswers() + "\n");
//        }).forEach(System.out::println);
//        List<Question> questions = exam.getQuestion().stream().toList();
//
//        List<String> studentsAnswers = new ArrayList<>();
//        for (int i = 0; i <= questions.size(); i++) {
//            IntStream.of(i).mapToObj(a -> {
//                Question q = questions.get(a);
//                return ("\n" + q.getQuestion() + "\n" + q.getAnswers() + "\n");
//            }).forEach(System.out::println);
//            System.out.println("Įveskite atsakymą:");
//            String answer = scanner.nextLine();
////            studentsAnswers.add(answer);
//            studentsAnswers.add(scanner.nextLine());
//
//
////        int counter = 0;
////
//////        do {
//////
//////            IntStream.of(counter++).mapToObj(a -> {
//////            Question q = questions.get(a);
//////            return ("\n" + q.getQuestion() + "\n" + q.getAnswers() + "\n");
//////        }).forEach(System.out::println);
//////            System.out.println("Įveskite atsakymą:");
//////            String answer = scanner.nextLine();
//////            studentsAnswers.add(scanner.nextLine());
//////
//////        } while(counter != questions.size());
//        }
//            studentsAnswers.forEach(System.out::println);
//
//

    }
}

