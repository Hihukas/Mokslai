package Answers;

import Exams.Exam;
import Exams.Question;
import Users.User;

import java.util.List;

public class StudentAnswer {
    private User user;
    private Exam exam;
    private List<Question> question;
    private String answer;

    public StudentAnswer() {
    }

    public StudentAnswer(User user, Exam exam, List<Question> question, String answer) {
        this.user = user;
        this.exam = exam;
        this.question = question;
        this.answer = answer;
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

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "StudentAnswer{" +
                "user=" + user +
                ", exam=" + exam +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }
}
