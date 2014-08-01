package com.exadel.model.entity;

import com.exadel.model.entity.student.ExadelWork;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
	private long id;
	private Set<ExadelWork> students;
	private String title;
	private Set<Technology> usedTechnologies;

	@ManyToMany
	public Set<Technology> getUsedTechnologies() {
		return usedTechnologies;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@ManyToMany
	public Set<ExadelWork> getStudents() {
		return students;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStudents(Set<ExadelWork> students) {
		this.students = students;
	}

	public void setUsedTechnologies(Set<Technology> usedTechnologies) {
		this.usedTechnologies = usedTechnologies;
	}

}
