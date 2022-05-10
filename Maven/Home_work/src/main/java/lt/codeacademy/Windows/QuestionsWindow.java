package lt.codeacademy.Windows;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.Question;

import java.util.*;
import java.util.stream.IntStream;

public class QuestionsWindow extends AbstractWindow {
    private Exam exam;
    private List<Integer> questionsAnswers = new LinkedList<>();

    public QuestionsWindow(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void window() throws Exception {
        System.out.printf("\nPasirinktas egzaminas:\nID: %s\nEgzamino tipas: %s\nPavadinimas: %s\n", exam.getId(), exam.getExamType(), exam.getName());
        exam.getQuestions().forEach(question -> printQuestion(question.getQuestion(), question.getAnswers()));
//        StudentAnswers studentAnswer = new StudentAnswers();
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
//        ObjectMapper objectMapper = new ObjectMapper();
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

    }

    private void printQuestion(String question, List<String> answers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + question);

        IntStream.range(0, answers.size())
                .mapToObj(i -> (i + 1) + ". " + answers.get(i))
                .forEach(System.out::println);

        System.out.println("\nĮveskite teisingą atsakymo numerį:");
//       try{ int answerInput = scanner.nextInt();} catch (InputMismatchException || NoSuchElementException e)
//        if (answerInput < 1 || answerInput > answers.size()) {
//            System.out.println("Tokio atsakymo nėra!");
//        }
//        questionsAnswers.add(answerInput);

    }
}
