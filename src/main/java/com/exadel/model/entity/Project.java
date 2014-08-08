package com.exadel.model.entity;

import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.Technology;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
	private long id;
	private Set<Student> students;
	private String title;
	private Set<Technology> usedTechnologies;

	@ManyToMany
    @JsonIgnore
    public Set<Technology> getUsedTechnologies() {
		return usedTechnologies;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@ManyToMany
    @JsonIgnore
	public Set<Student> getStudents() {
		return students;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void setUsedTechnologies(Set<Technology> usedTechnologies) {
		this.usedTechnologies = usedTechnologies;
	}

}
