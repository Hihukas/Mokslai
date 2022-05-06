package v2.frame;

import Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TestsFrame {
    public void print() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });
        System.out.println("""
                Pasirinkite norimą laikyti egzaminą:
                """);

        IntStream.range(0, exams.size())
                .mapToObj(i -> {
                    Exam v = exams.get(i);
                    return (i + 1) + ": Egzamino pavadinimas: " + v.getName() + ", Egzamino tipas: " + v.getExamType();
                })
                .forEach(System.out::println);

        Exam exam = exams.get(scanner.nextInt() - 1);

        System.out.println("exam selected: " + exam.getName());

    }
}

