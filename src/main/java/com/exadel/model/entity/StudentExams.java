package com.exadel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "exam")
public class StudentExams implements Serializable {
	private long id;
    private double summer_grade,winter_grade;
    private Student student;
    private int year;
	public StudentExams() {
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
    @ManyToOne
    @NaturalId
    @JoinColumn(name="student_fk",insertable=false,updatable=false)
	public Student getStudent() {
		return student;
	}
    @NaturalId
	public int getYear() {
		return year;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setYear(int year) {
		this.year = year;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
