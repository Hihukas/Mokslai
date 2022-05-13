package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class QuestionsWindow extends AbstractWindow {
    private Exam exam;
    private User user;
    private Enum<UserType> userType;
    private List<Integer> questionsAnswers = new LinkedList<>();
    private List<StudentsAnswers> studentsAnswers = new ArrayList<>();

    public QuestionsWindow(Exam exam, Enum<UserType> userType, User user) {
        this.exam = exam;
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        System.out.printf("\nPasirinktas egzaminas:\nID: %s\nEgzamino tipas: %s\nPavadinimas: %s\n", exam.getId(), exam.getExamType(), exam.getName());

        exam.getQuestions().forEach(question -> printQuestion(question.getQuestion(), question.getAnswers()));

        StudentsAnswers studentsAnswers = createStudentAnswersObject();
        saveStudentAnswers(studentsAnswers);
        saveAnswersToFile(studentsAnswers);

        System.out.printf("\nAčiū už atsakymus! Jie išsaugoti!\nJūsų pažymys: %s\n", testResult());
        testResult();

        Thread.sleep(5000);
        StudentWindow window = new StudentWindow(userType, user);
        window.window();
    }

    private String testResult() {
        List<Integer> correctAnswers = exam.getQuestions().stream()
                .map(question -> question.getCorrectAnswer()).toList();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < exam.getQuestions().size(); i++) {
            if (correctAnswers.get(i).equals(questionsAnswers.get(i))) {
                result.add(i);
            }
        }

        double grade;
        if (result.size() == exam.getQuestions().size()) {
            grade = 10D;
        } else {
            grade = ((result.size() * 10D) / exam.getQuestions().size());
        }

        return String.format("%.0f", grade);
    }

    private StudentsAnswers createStudentAnswersObject() {
        StudentsAnswers studentsAnswers = new StudentsAnswers();
        studentsAnswers.setUser(user);
        studentsAnswers.setExam(exam);
        studentsAnswers.setAnswers(questionsAnswers);
        studentsAnswers.setGrade(testResult());
        LocalDateTime localDateTime = LocalDateTime.now();
        studentsAnswers.setTime(localDateTime.toString());
        return studentsAnswers;
    }

    private void saveStudentAnswers(StudentsAnswers studentAnswer) {
        studentsAnswers.add(studentAnswer);
    }

    private void saveAnswersToFile(StudentsAnswers studentAnswers) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            File file = new File("StudentsAnswers.json");

            List<StudentsAnswers> studentsAnswersList = objectMapper.readValue(file, new TypeReference<>() {
            });
            studentsAnswersList.add(studentAnswers);

            objectMapper.writeValue(file, studentsAnswersList);
        } catch (IOException e) {
            System.out.println("Jūsų egzamino išsaugoti nepavyko. Prašome kreiptis į dėstytoją.");
        }
    }

    private void printQuestion(String question, List<String> answers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + question);

        IntStream.range(0, answers.size())
                .mapToObj(i -> (i + 1) + ". " + answers.get(i))
                .forEach(System.out::println);

        System.out.println("\nĮveskite teisingą atsakymo numerį:");
        int answerInput = 0;

        try {
            answerInput = scanner.nextInt();
            if (answerInput < 1 || answerInput > answers.size()) {
                System.out.println("Tokio atsakymo nėra!");
                printQuestion(question, answers);
            }
            if (answerInput <= answers.size() && answerInput > 0) {
                questionsAnswers.add(answerInput);
            }
        } catch (InputMismatchException e) {
            System.out.println("Galimi tik skaičiai.");
            printQuestion(question, answers);
        }
    }
}