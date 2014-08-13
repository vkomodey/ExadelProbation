package com.exadel.model.entity.student;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

import com.exadel.model.NamedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class University implements NamedEntity{

	private Long id;
	private String name;
	private Set<Faculty> faculties;
	public University(){
		
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="university")
	@JsonIgnore
	public Set<Faculty> getFaculties() {
		return faculties;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@NaturalId
	public String getName() {
		return name;
	}
	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return getName();
	}
}
