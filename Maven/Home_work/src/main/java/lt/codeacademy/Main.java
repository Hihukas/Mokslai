package lt.codeacademy;

import lt.codeacademy.Answers.StudentAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Exams.ExamType;
import lt.codeacademy.Exams.Question;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;
import lt.codeacademy.Windows.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
//        FrameFactory frameFactory = new FrameFactory(createTestState());
        //       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();


    MainWindow mainWindow = new MainWindow();
    mainWindow.window();

    }

//    private static State createTestState() {
//        State result = new State();
//        result.setUser(createTestUser());
//        result.setExams(Stream.of(
//                createTestExam(UUID.randomUUID(), "OOP"), createTestExam(UUID.randomUUID(), "AA"))
//                .collect(Collectors.toList()));
//        result.setAnswer(
//                createTestAnswers(
//                        result.getUser(),
//                        result.getExams().get(0),
//                        LocalDateTime.of(
//                                LocalDate.of(2022, 5, 7),
//                                LocalTime.of(22, 0)))
//        );
//        return result;
//    }
//
//    private static User createTestUser() {
//        User user = new User();
//        user.setId(UUID.randomUUID());
//        user.setUserType(UserType.STUDENT);
//        user.setUsername("userName");
//        user.setPassword("password");
//        user.setName("name");
//        user.setSurname("surname");
//        return user;
//    }
//
//    private static Exam createTestExam(UUID id, String name) {
//        Exam exam = new Exam();
//        exam.setId(id);
//        exam.setName(name);
//        exam.setExamType(ExamType.TEST);
//        exam.setQuestions(createTestQuestions());
//        return exam;
//    }
//
//    private static List<Question> createTestQuestions() {
//        return Stream.of(
//                new Question("First question lalala?", List.of("answer 1", "answer 2"), 2),
//                new Question("Second question Tralala?", List.of("answer 1", "answer 2"), 1),
//                new Question("Third question Trololo?", List.of("answer 1", "answer 2", "answer 3"), 3)
//        ).collect(Collectors.toList());
//    }
//
//    private static List<StudentAnswers> createTestAnswers(User user, Exam exam, LocalDateTime time) {
//        StudentAnswers result = new StudentAnswers();
//        result.setUser(user);
//        result.setExam(exam);
//        result.setAnswers(exam.getQuestions().stream().map(q -> q.getAnswers().size()).collect(Collectors.toList()));
//        result.setTime(time);
//        return Stream.of(result).collect(Collectors.toList());
//    }

}
