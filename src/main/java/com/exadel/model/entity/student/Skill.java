package com.exadel.model.entity.student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	
	private String level;
	private long id;
	private SkillType type;
	
	public Skill() {
	}
	public Skill(SkillType st) {
		this.type=st;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	@Column(name="level")
	public String getLevel() {
		return level;
	}
	@OneToOne(cascade=CascadeType.ALL)
	public SkillType getType() {
		return type;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setType(SkillType type) {
		this.type = type;
	}
}