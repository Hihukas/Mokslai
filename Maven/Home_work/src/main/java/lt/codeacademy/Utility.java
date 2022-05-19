package lt.codeacademy;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;

import java.io.File;
import java.util.Scanner;

public class Utility {
    private User user;
    private Exam exam;
    private StudentsAnswers studentsAnswers;
    private Scanner scanner = new Scanner(System.in);
    private File file;
    private ObjectMapper objectMapper = new ObjectMapper();

    public Utility() {
    }

    public Utility(User user, Exam exam, StudentsAnswers studentsAnswers, Scanner scanner, File file, ObjectMapper objectMapper) {
        this.user = user;
        this.exam = exam;
        this.studentsAnswers = studentsAnswers;
        this.scanner = scanner;
        this.file = file;
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

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
