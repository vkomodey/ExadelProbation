package com.exadel.model.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.exadel.model.NamedEntity;

@Entity
public class Technology implements NamedEntity{
	private Long id;
	private String name;
	public Technology() {
	}
	public Technology(String name) {
		this.setName(name);
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@NaturalId
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
