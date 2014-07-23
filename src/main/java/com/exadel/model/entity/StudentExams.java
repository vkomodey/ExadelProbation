package com.exadel.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exam")
public class StudentExams implements Serializable {
	private long id;
    private double grade;
    private boolean summer;
    private Student student;
    private int course;
	public StudentExams() {
    }
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public double getGrade() {
		return grade;
	}
	@NaturalId
	public boolean isSummer() {
		return summer;
	}
	@JsonIgnore
	@NaturalId
	@ManyToOne
	@JoinColumn(name="stud_id")
	public Student getStudent() {
		return student;
	}
	@NaturalId
	public int getCourse() {
		return course;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public void setSummer(boolean summer) {
		this.summer = summer;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setCourse(int course) {
		this.course = course;
	}

}
