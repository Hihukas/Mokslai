package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentsExamsResultsWindow extends AbstractWindow {
    private final User user;

    public StudentsExamsResultsWindow(User user) {
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("StudentsAnswers.json");

        Scanner scanner = new Scanner(System.in);
        List<StudentsAnswers> studentsAnswersList = objectMapper.readValue(file, new TypeReference<>() {
        });

        studentsAnswersList.stream()
                .sorted(Comparator.comparing((StudentsAnswers sa) -> sa.getUser().getName())
                        .thenComparing(sa -> sa.getUser().getSurname())
                        .thenComparing(sa -> LocalDateTime.parse(sa.getTime())))
                .map(e -> "\nStudento vardas: " + e.getUser().getName() +
                        "\nStudento pavardė: " + e.getUser().getSurname() +
                        "\nEgzamino ID: " + e.getExam().getId() +
                        ", Egzamino pavadinimas: " + e.getExam().getName() +
                        ", Egzamino tipas: " + e.getExam().getExamType() +
                        "\nPažymys: " + e.getGrade() +
                        "\nEgzamino laikymo data: " + e.getTime())
                .forEachOrdered(System.out::println);

        ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user);
        examsCreateWindow.returnAction(scanner, user);

//        returnAction();
//    }
//
//    private void returnAction() throws Exception {
//        String input;
//        do {
//            System.out.println("\n[1] Grįžti į dėstytojo meniu.");
//            Scanner scanner = new Scanner(System.in);
//            input = scanner.nextLine();
//            if ("1".equals(input)) {
//                TeacherWindow teacherWindow = new TeacherWindow(user);
//                teacherWindow.window();
//            } else {
//                System.out.println("Tokio veiksmo nėra. Bandykite dar kartą.");
//            }
//        } while (!input.equals("1"));
//    }
    }
}
