package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class StudentsExamsResultsWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public StudentsExamsResultsWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("StudentsAnswers.json");
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

        ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user, utility);
        examsCreateWindow.returnAction(user);
    }
}
