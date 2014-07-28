package com.exadel.model.entity.student;


import javax.persistence.*;


@Entity
@Table(name="skill_type")
public class SkillType {
	private Long id;
	private String name;
	public SkillType() {
	}

	public SkillType(String name) {
		this.name=name;
	}

	@Id
	@GeneratedValue
    public Long getId() {
		return id;
	}
	@Column(name="type")
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
