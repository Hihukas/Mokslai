package lt.codeacademy.json.example.SecondTask;

import java.io.Serializable;

public class Company implements Serializable {
  private String name;
  private String code;
  private int employers;
  private double salaryAverage;

    public Company() {
    }

    public Company(String name, String code, int employers, double salaryAverage) {
        this.name = name;
        this.code = code;
        this.employers = employers;
        this.salaryAverage = salaryAverage;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getEmployers() {
        return employers;
    }

    public double getSalaryAverage() {
        return salaryAverage;
    }
}
