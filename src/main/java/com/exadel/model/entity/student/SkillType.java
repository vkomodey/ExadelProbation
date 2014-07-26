package com.exadel.model.entity.student;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="skill_type")
public class SkillType {
	private Long id;
	@Id
	@GeneratedValue
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String name;

	public SkillType() {
	}
	public SkillType(String name) {
		this.name=name;
	}
	@Column(name="type")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
