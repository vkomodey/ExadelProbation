package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_exams")
public class StudentExams {
    private long id;
    private long studentId;
    @Column(name = "student_id")
    public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long student_id) {
		this.studentId = student_id;
	}

	private int year;
    private double summer_grade,winter_grade;

    public StudentExams() {
    }
    @Id
    @GeneratedValue
    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "summer_grade")
    public double getSummer_grade() {
        return summer_grade;
    }

    public void setSummer_grade(double summer_grade) {
        this.summer_grade = summer_grade;
    }

    @Column(name = "winter_grade")
    public double getWinter_grade() {
        return winter_grade;
    }

    public void setWinter_grade(double winter_grade) {
        this.winter_grade = winter_grade;
    }
}
