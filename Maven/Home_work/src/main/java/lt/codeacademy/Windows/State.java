package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentAnswers;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;

import java.util.ArrayList;
import java.util.List;

public class State {
    private User user;
    private Exam exam;
    private List<Exam> exams = new ArrayList<>();
    private List<StudentAnswers> answer = new ArrayList<>();

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

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<StudentAnswers> getAnswer() {
        return answer;
    }

    public void setAnswer(List<StudentAnswers> answer) {
        this.answer = answer;
    }
}
