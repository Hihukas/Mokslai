package Exams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamsList {
    public static void main(String[] args) throws IOException {
        ExamsList examsList = new ExamsList();
        examsList.createList();
    }

    public void createList() throws IOException {
        List<String> a = new ArrayList<>();
        a.add("sss");
        List<String> b = Collections.singletonList("sss");
        List<String> c = Arrays.asList("sss", "sss");
        List<String> d = Stream.of("sss", "sssds").toList();


        List<Exam> exams = new ArrayList<>();
        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, "OOP",
                List.of(new Question("1. Klausimas?", List.of("a", "b", "c"), "b"), new Question("2. Klausimas?", List.of("a", "b", "c"), "a"), new Question("2. Klausimas?", List.of("a", "b", "c"), "c"))));
        exams.add(new Exam(UUID.randomUUID(), ExamType.TEST, "OOP",
                List.of(new Question("1. Klausimas?", List.of("a", "b", "c"), "a"), new Question("2. Klausimas?", List.of("a", "b", "c"), "b"), new Question("2. Klausimas?", List.of("a", "b", "c"), "c"))));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        objectMapper.writeValue(file, exams);
    }
}
