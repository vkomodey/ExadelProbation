package com.exadel.model.entity.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exam")
public class StudentExams implements Serializable {
	private Long id;
    private double grade;
    private Boolean summer;
    private Student student;
    private Integer course;
	public StudentExams() {
    }
	@NaturalId
	public Integer getCourse() {
		return course;
	}
	public double getGrade() {
		return grade;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	@JsonIgnore
	@NaturalId
	@ManyToOne
    @JoinColumn(name = "student_fk", referencedColumnName = "id")
	public Student getStudent() {
		return student;
	}
	@NaturalId
	public Boolean isSummer() {
		return summer;
	}
	public void setCourse(Integer course) {
		this.course = course;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setSummer(Boolean summer) {
		this.summer = summer;
	}

}
