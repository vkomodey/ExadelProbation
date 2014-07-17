package com.exadel.model.entity;

/**
 * Created by Ivan on 17.07.14.
 */
public class Student_Exams {
    private long id;
    private int year;
    private double summer_grade,winter_grade;

    public Student_Exams() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSummer_grade() {
        return summer_grade;
    }

    public void setSummer_grade(double summer_grade) {
        this.summer_grade = summer_grade;
    }

    public double getWinter_grade() {
        return winter_grade;
    }

    public void setWinter_grade(double winter_grade) {
        this.winter_grade = winter_grade;
    }
}
