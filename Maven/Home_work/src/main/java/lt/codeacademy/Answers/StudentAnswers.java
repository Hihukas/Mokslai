package lt.codeacademy.Answers;

import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;

import java.time.LocalDateTime;
import java.util.List;

public class StudentAnswers {
    private User user;
    private Exam exam;
    private List<Integer> answers;

    private LocalDateTime time;

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

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
