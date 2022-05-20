package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Utility;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class QuestionsWindow extends AbstractWindow {
    private final Utility utility;
    private final List<Integer> questionsAnswers = new LinkedList<>();
    private final List<StudentsAnswers> studentsAnswers = new ArrayList<>();

    public QuestionsWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        System.out.printf("\nPasirinktas egzaminas:\nID: %s\nEgzamino tipas: %s\nPavadinimas: %s\n", utility.getExam().getId(), utility.getExam().getExamType(), utility.getExam().getName());

        utility.getExam().getQuestions().forEach(question -> printQuestion(question.getQuestion(), question.getAnswers()));

        StudentsAnswers studentAnswers = createStudentAnswersObject();
        studentsAnswers.add(studentAnswers);
        utility.setStudentsAnswersList(studentsAnswers);

        System.out.printf("\nAčiū už atsakymus! Jie išsaugoti!\nJūsų pažymys: %s\nEgzaminą perlaikyti bus galima po 48 valandų.\n", testResult());

        ReturnAction returnAction = new ReturnAction(utility);
        returnAction.returnAction(utility.getUser());
    }

    private String testResult() {
        List<Integer> correctAnswers = utility.getExam().getQuestions().stream()
                .map(Question::getCorrectAnswer).toList();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < utility.getExam().getQuestions().size(); i++) {
            if (correctAnswers.get(i).equals(questionsAnswers.get(i))) {
                result.add(i);
            }
        }

        double grade = ((result.size() * 10D) / utility.getExam().getQuestions().size());

        return String.format("%.0f", grade);
    }

    private StudentsAnswers createStudentAnswersObject() {
        StudentsAnswers studentsAnswers = new StudentsAnswers();
        studentsAnswers.setUser(utility.getUser());
        studentsAnswers.setExam(utility.getExam());
        studentsAnswers.setAnswers(questionsAnswers);
        studentsAnswers.setGrade(testResult());
        LocalDateTime localDateTime = LocalDateTime.now();
        studentsAnswers.setTime(localDateTime.toString());
        return studentsAnswers;
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
