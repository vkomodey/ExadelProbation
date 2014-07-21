package com.exadel.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="skill_type")
public class SkillType {
    private String name;

	public SkillType() {
	}
	@Id
	@Column(name="type")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
