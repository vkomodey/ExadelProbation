package com.exadel.model.entity.government;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Curator extends Feedbackable  {
	@Override
	@Transient
	@JsonIgnore
	public String getRole() {
		return SpringSecurityRole.CURATOR;
	}

	private List<Student> students;

	@JsonManagedReference
	@ManyToMany(mappedBy="curator")
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
