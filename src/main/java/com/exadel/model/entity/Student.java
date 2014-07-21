package com.exadel.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.exadel.model.enums.StudentStateEnum;


@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name="id")
public class Student extends User{
	private Study study;
    private StudentStateEnum state;
    private Set<Skill> skillSet;
    private ExadelPractice practice;
    private ExadelWork work;
    
    
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    public Set<Skill> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
    @Enumerated(EnumType.STRING)
	public StudentStateEnum getState() {
		return state;
	}
	public void setState(StudentStateEnum state) {
		this.state = state;
	}
	
	@Embedded
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	public ExadelPractice getPractice() {
		return practice;
	}
	public void setPractice(ExadelPractice practice) {
		this.practice = practice;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	public ExadelWork getWork() {
		return work;
	}
	public void setWork(ExadelWork work) {
		this.work = work;
	}


}
