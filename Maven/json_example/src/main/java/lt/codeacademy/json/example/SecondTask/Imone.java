package lt.codeacademy.json.example.SecondTask;

import java.io.Serializable;

public class Imone implements Serializable {
    private String name;
    private String companyCode;
    private int employers;
    private double averageSalary;

    public Imone() {
    }

    public Imone(String name, String companyCode, int employers, double averageSalary) {
        this.name = name;
        this.companyCode = companyCode;
        this.employers = employers;
        this.averageSalary = averageSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getEmployers() {
        return employers;
    }

    public void setEmployers(int employers) {
        this.employers = employers;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    @Override
    public String toString() {
        return "Imone{" +
                "name='" + name + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", employers=" + employers +
                ", averageSalary=" + averageSalary +
                '}';
    }
}
