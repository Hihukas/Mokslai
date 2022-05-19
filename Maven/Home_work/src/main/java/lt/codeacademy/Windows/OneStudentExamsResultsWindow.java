package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;

public class OneStudentExamsResultsWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public OneStudentExamsResultsWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        List<StudentsAnswers> oneStudentsAnswersList = fillOneStudentsAnswersList();

        System.out.println("Egzaminų sąrašas:");

        IntStream.range(0, oneStudentsAnswersList.size())
                .mapToObj(i -> {
                    StudentsAnswers e = oneStudentsAnswersList.get(i);
                    return (i + 1) + " Egzamino ID: " + e.getExam().getId() +
                            ", Egzamino pavadinimas: " + e.getExam().getName() +
                            ", Egzamino tipas: " + e.getExam().getExamType() +
                            ", Pažymys: " + e.getGrade() +
                            ", Egzamino laikymo data: " + e.getTime();
                })
                .forEach(System.out::println);

        returnAction();
    }

    private void returnAction() throws Exception {
        String input;
        do {
            System.out.println("\n[1] Grįžti į pagrindinį meniu.");
            input = utility.getScanner().nextLine();
            if ("1".equals(input)) {
                StudentWindow window = new StudentWindow(user, utility);
                window.window();
            } else {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
            }
        } while (!input.equals("1"));
    }

    public List<StudentsAnswers> fillOneStudentsAnswersList() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<StudentsAnswers> filledOneStudentsAnswersList = new ArrayList<>();
//
//        File file = new File("StudentsAnswers.json");
//        List<StudentsAnswers> studentsAnswersList = objectMapper.readValue(file, new TypeReference<>() {
//        });

        for (StudentsAnswers id : utility.getStudentsAnswersList()) {
            if (id.getUser().getId().equals(user.getId())) {
                filledOneStudentsAnswersList.add(id);
            }
        }
        return filledOneStudentsAnswersList;
    }
}
