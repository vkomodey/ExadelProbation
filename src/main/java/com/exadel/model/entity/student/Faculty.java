package com.exadel.model.entity.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import com.exadel.model.NamedEntity;
@Entity
public class Faculty implements NamedEntity{
	private Long id;
	private String name;
	private University university;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@NaturalId
	public String getName() {
		return name;
	}
	@ManyToOne
	@NaturalId
	public University getUniversity() {
		return university;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public Faculty(){
		
	}
	@Override
	public String toString() {
		return getName();
	}
}
