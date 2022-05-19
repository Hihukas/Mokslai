package lt.codeacademy;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Utility {
    private User user;
    private Exam exam;
    private StudentsAnswers studentsAnswers;
    private List<StudentsAnswers> studentsAnswersList;
    List<User> usersList;
    List<Exam> examsList;
    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper objectMapper = new ObjectMapper();

    public Utility() {
    }

    public Utility(User user, Exam exam, StudentsAnswers studentsAnswers, List<StudentsAnswers> studentsAnswersList, List<User> usersList, List<Exam> examsList, Scanner scanner, ObjectMapper objectMapper) {
        this.user = user;
        this.exam = exam;
        this.studentsAnswers = studentsAnswers;
        this.studentsAnswersList = studentsAnswersList;
        this.usersList = usersList;
        this.examsList = examsList;
        this.scanner = scanner;
        this.objectMapper = objectMapper;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public StudentsAnswers getStudentsAnswers() {
        return studentsAnswers;
    }

    public void setStudentsAnswers(StudentsAnswers studentsAnswers) {
        this.studentsAnswers = studentsAnswers;
    }

    public List<StudentsAnswers> getStudentsAnswersList() {
        return studentsAnswersList;
    }

    public void setStudentsAnswersList(List<StudentsAnswers> studentsAnswersList) {
        this.studentsAnswersList = studentsAnswersList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public List<Exam> getExamsList() {
        return examsList;
    }

    public void setExamsList(List<Exam> examsList) {
        this.examsList = examsList;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
