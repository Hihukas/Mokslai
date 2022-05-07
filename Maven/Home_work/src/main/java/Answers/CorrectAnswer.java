package Answers;

import Exams.Exam;
import Exams.Question;

public class CorrectAnswer {
    private Exam exam;
    private Question question;

    public CorrectAnswer() {
    }

    public CorrectAnswer(Exam exam, Question question) {
        this.exam = exam;
        this.question = question;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "CorrectAnswer{" +
                "exam=" + exam +
                ", question=" + question +
                '}';
    }
}

