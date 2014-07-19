package com.exadel.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.exadel.model.enums.StudentStateEnum;


@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name="id")
public class Student extends User{
	private Study study;
    private StudentStateEnum stateEnum;
    private Set<Skill> skillSet;
    
    @OneToMany(cascade=CascadeType.ALL)
    public Set<Skill> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	@Embedded
    @Enumerated(EnumType.STRING)
	public StudentStateEnum getStateEnum() {
		return stateEnum;
	}
	public void setStateEnum(StudentStateEnum stateEnum) {
		this.stateEnum = stateEnum;
	}
	
	@Embedded
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}


}
