package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ExamsEditingWindow extends AbstractWindow {
    private final User user;
    private final Exam exam;

    private final Utility utility;
    private final int index;

    public ExamsEditingWindow(User user, Exam exam, int index, Utility utility) {
        this.user = user;
        this.exam = exam;
        this.index = index;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });

        List<Question> oldQuestions = exam.getQuestions().stream().toList();

        List<Question> questions = new ArrayList<>(oldQuestions);

        ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user, utility);

        examsCreateWindow.questionsCreate(questions);

        exams.set(index, new Exam(exam.getId(), exam.getExamType(), exam.getName(), questions));

        objectMapper.writeValue(file, exams);

        System.out.println("\nInformacija išsaugota.");

        examsCreateWindow.returnAction(user);
    }
}

