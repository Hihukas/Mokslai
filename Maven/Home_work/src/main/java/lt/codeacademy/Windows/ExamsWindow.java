package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ExamsWindow extends AbstractWindow {

    private Enum<UserType> userType;

    public ExamsWindow(Enum<UserType> userType) {
        this.userType = userType;
    }

    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });

        System.out.println("Egzaminų sąrašas:");

        IntStream.range(0, exams.size())
                .mapToObj(i -> {
                    Exam e = exams.get(i);
                    return "[" + (i + 1) + "] Egzamino ID: " + e.getId() +
                            ", Egzamino pavadinimas: " + e.getName() +
                            ", Egzamino tipas: " + e.getExamType();
                })
                .forEach(System.out::println);

        System.out.println("\nPasirinkite egzaminą:");

        Exam exam = exams.get(scanner.nextInt() - 1);

        if (userType.equals(UserType.STUDENT)) {
            QuestionsWindow questionsWindow = new QuestionsWindow(exam);
            questionsWindow.window();
        } else {
            System.out.println("Dėstytojo langas");
        }


    }

//    private boolean canTakeExam(Exam exam) {
//        return !getState().getAnswer().stream()
//                //TODO add check that time has passed 48 hours
//                .anyMatch(examAnswers -> examAnswers.getExam().getId().equals(exam.getId()));
//    }
}

