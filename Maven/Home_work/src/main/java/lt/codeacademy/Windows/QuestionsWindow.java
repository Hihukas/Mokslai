package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuestionsWindow extends AbstractWindow {
    private Exam exam;
//
//    private List<Integer> questionsAnswers = new LinkedList<>();
//
//    private final Scanner scanner = new Scanner(System.in);
//
//    private ObjectMapper objectMapper = new ObjectMapper();

    public QuestionsWindow(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void window() throws Exception {
        System.out.printf("Pasirinktas egzaminas:\nID: %s\nTipas: %s\nPavadinimas: %s\n", exam.getId(), exam.getExamType(), exam.getName());
//        exam.getQuestions().forEach(question -> printQuestion(question.getQuestion(), question.getAnswers()));
//        StudentAnswers studentAnswer = createStudentAnswersObject();
//        saveAnswersToState(studentAnswer);
////        saveAnswersToFile(studentAnswer);
//        System.out.println("Aciu uz atsakymus jie issaugoti, Jusu rezultatas:" + calcTestResult());
//        Thread.sleep(3000);
//        StudentFrame frame = new StudentFrame(getState());
//        frame.window();
//    }
//
//    private void saveAnswersToState(StudentAnswers studentAnswer) {
//        getState().getAnswer().add(studentAnswer);
//    }
//
//    private String calcTestResult() {
//        return "NaN";
//    }
//
//    private void saveAnswersToFile(StudentAnswers studentAnswer) {
//        try {
//            File file = new File("answers/StudentsAnswers.json");
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            objectMapper.writeValue(file, studentAnswer);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private StudentAnswers createStudentAnswersObject() {
//        StudentAnswers studentAnswers = new StudentAnswers();
//        studentAnswers.setUser(getState().getUser());
//        studentAnswers.setExam(exam);
//        studentAnswers.setAnswers(questionsAnswers);
//        studentAnswers.setTime(LocalDateTime.now());
//        return studentAnswers;
//    }
//
//    private void printQuestion(String question, List<String> answers) {
//
//        System.out.println(question);
//        System.out.println("--------------------------------------------------");
//        IntStream.range(0, answers.size())
//                .mapToObj(i -> (i + 1) + ". " + answers.get(i))
//                .forEach(System.out::println);
//        System.out.println("--------------------------------------------------");
//
//        System.out.println("Iveskite teisinga atsakymo numeri:");
//        int answerInput = scanner.nextInt();
//        if (answerInput < 1 || answerInput > answers.size()) {
//            throw new RuntimeException("Illegal input value of :" + answerInput);
//        }
//        questionsAnswers.add(answerInput);
//
    }
}
