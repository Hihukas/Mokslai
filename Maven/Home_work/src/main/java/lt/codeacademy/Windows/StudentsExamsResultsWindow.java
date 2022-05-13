package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentsExamsResultsWindow extends AbstractWindow {
    private User user;
    private Enum<UserType> userType;

    public StudentsExamsResultsWindow(Enum<UserType> userType, User user) {
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("StudentsAnswers.json");
        List<StudentsAnswers> studentsAnswersList = objectMapper.readValue(file, new TypeReference<>() {
        });

        IntStream.range(0, studentsAnswersList.size())
                .mapToObj(i -> {
                    StudentsAnswers e = studentsAnswersList.get(i);
                    return "\nStudento vardas: " + e.getUser().getName() +
                            "\nStudento pavardė: " + e.getUser().getSurname() +
                            "\nEgzamino ID: " + e.getExam().getId() +
                            ", Egzamino pavadinimas: " + e.getExam().getName() +
                            ", Egzamino tipas: " + e.getExam().getExamType() +
                            "\nPažymys: " + e.getGrade() +
                            "\nEgzamino laikymo data: " + e.getTime();
                })
                .sorted()
                .forEachOrdered(System.out::println);

        returnAction();
    }

    private void returnAction() throws Exception {
        String input;
        do {
            System.out.println("\n[1] Grįžti į dėstytojo meniu.");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if ("1".equals(input)) {
                TeacherWindow teacherWindow = new TeacherWindow(userType, user);
                teacherWindow.window();
            } else {
                System.out.println("Tokio veiksmo nėra. Bandykite dar kartą.");
            }
        } while (!input.equals("1"));
    }
}
