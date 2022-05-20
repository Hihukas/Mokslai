package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class QuestionsWindow extends AbstractWindow {
    private final Exam exam;
    private final User user;
    private final Utility utility;
    private final List<Integer> questionsAnswers = new LinkedList<>();
    private final List<StudentsAnswers> studentsAnswers = new ArrayList<>();

    public QuestionsWindow(Exam exam, User user, Utility utility) {
        this.exam = exam;
        this.user = user;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        System.out.printf("\nPasirinktas egzaminas:\nID: %s\nEgzamino tipas: %s\nPavadinimas: %s\n", exam.getId(), exam.getExamType(), exam.getName());

        exam.getQuestions().forEach(question -> printQuestion(question.getQuestion(), question.getAnswers()));

        StudentsAnswers studentsAnswers = createStudentAnswersObject();
        saveStudentAnswers(studentsAnswers);
        saveAnswersToFile(studentsAnswers);

        System.out.printf("\nAčiū už atsakymus! Jie išsaugoti!\nJūsų pažymys: %s\nEgzaminą perlaikyti bus galima po 48 valandų.\n", testResult());

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction(user);
    }

    private String testResult() {
        List<Integer> correctAnswers = exam.getQuestions().stream()
                .map(Question::getCorrectAnswer).toList();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < exam.getQuestions().size(); i++) {
            if (correctAnswers.get(i).equals(questionsAnswers.get(i))) {
                result.add(i);
            }
        }

        double grade = ((result.size() * 10D) / exam.getQuestions().size());

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
        System.out.println("\n" + question);

        IntStream.range(0, answers.size())
                .mapToObj(i -> (i + 1) + ". " + answers.get(i))
                .forEach(System.out::println);

        System.out.println("\nĮveskite teisingą atsakymo numerį:");

        try {
            int answerInput = utility.getScanner().nextInt();
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
