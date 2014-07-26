package com.exadel.model.entity.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Technology {
	private Long id;
	private String name;
	public Technology() {
	}
	public Technology(String name) {
		this.setName(name);
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
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
