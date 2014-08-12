package com.exadel.model.entity.student;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "skill")
public class Skill {
	
	private String level;
	private Long id;
	private Technology type;
	
	public Skill() {
	}
	public Skill(Technology st) {
		this.type=st;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
	public Long getId() {
		return id;
	}

	@Column(name="level")
	public String getLevel() {
		return level;
	}
	@OneToOne
	public Technology getType() {
		return type;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setType(Technology type) {
		this.type = type;
	}
}