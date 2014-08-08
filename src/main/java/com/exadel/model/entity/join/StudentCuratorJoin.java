package com.exadel.model.entity.join;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;

@Entity
@Table(name="student_curator")
public class StudentCuratorJoin implements Serializable{
	private Calendar assignmentDate;
	private Curator curator;
	private Student student;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCuratorJoin other = (StudentCuratorJoin) obj;
		if (curator == null) {
			if (other.curator != null)
				return false;
		} else if (!curator.equals(other.curator))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	@Column(name="assignment_date")
	public Calendar getAssignmentDate() {
		return assignmentDate;
	}
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="curator", referencedColumnName="id")
	public Curator getCurator() {
		return curator;
	}
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="student", referencedColumnName="id")
	public Student getStudent() {
		return student;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curator == null) ? 0 : curator.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}
	public void setAssignmentDate(Calendar assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public void setCurator(Curator curator) {
		this.curator = curator;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
