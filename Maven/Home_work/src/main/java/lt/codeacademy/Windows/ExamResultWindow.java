package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class ExamResultWindow extends AbstractWindow {
    private User user;
    private Enum<UserType> userType;

    public ExamResultWindow(Enum<UserType> userType, User user) {
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        List<StudentsAnswers> oneStudentsAnswersList =new ArrayList<>();
        fillOneStudentsAnswersList(oneStudentsAnswersList);

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
            System.out.println("\n[1] Grįžti į studento meniu.");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    StudentWindow window = new StudentWindow(userType, user);
                    window.window();
                }
                default -> System.out.println("Tokio veiksmo nėra. Bandykite dar kartą.");
            }
        } while (!input.equals("1"));
    }

    private void fillOneStudentsAnswersList(List<StudentsAnswers> oneStudentsAnswersList) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("StudentsAnswers.json");
        List<StudentsAnswers> studentsAnswersList = objectMapper.readValue(file, new TypeReference<>() {
        });

        for(StudentsAnswers id: studentsAnswersList){
            if(id.getUser().getId().equals(user.getId())){
                oneStudentsAnswersList.add(id);
            }
        }
    }
}
