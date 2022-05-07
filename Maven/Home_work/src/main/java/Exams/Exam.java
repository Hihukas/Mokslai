package Exams;

import java.util.List;
import java.util.UUID;

public class Exam{
    private UUID id;
    private ExamType examType;
    private String name;
    private List<Question> question;

    public Exam() {
    }

    public Exam(UUID id, ExamType examType, String name, List<Question> question) {
        this.id = id;
        this.examType = examType;
        this.name = name;
        this.question = question;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examType=" + examType +
                ", name='" + name + '\'' +
                ", question=" + question +
                '}';
    }
}
