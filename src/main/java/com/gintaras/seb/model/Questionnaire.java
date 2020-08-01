package com.gintaras.seb.model;

/**
 * Holds the questionnaire information gathered for the user.
 *
 * @author gintaras
 */
public class Questionnaire {

    /**
     * Age of the user.
     */
    private String age;

    /**
     * Whether the user is student or not (string representation).
     */
    private String student;

    /**
     * Users annual income.
     */
    private String income;

    public Questionnaire() {
    }

    public Questionnaire(String age, String student, String income) {
        this.age = age;
        this.student = student;
        this.income = income;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
