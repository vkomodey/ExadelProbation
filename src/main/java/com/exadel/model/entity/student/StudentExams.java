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
    private Student student;
    private Integer semester;
	public StudentExams() {
    }
	
	public double getGrade() {
		return grade;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@NaturalId
	public Integer getSemester() {
		return semester;
	}
	@JsonIgnore
	@NaturalId
	@ManyToOne
    @JoinColumn(name = "student_fk", referencedColumnName = "id")
	public Student getStudent() {
		return student;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
