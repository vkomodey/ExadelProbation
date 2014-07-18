package com.exadel.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
    private StudentStateEnum stateEnum;
    private List<SkillSet> skillSetList;
    
    @Embedded
    @Enumerated(EnumType.STRING)
	public StudentStateEnum getStateEnum() {
		return stateEnum;
	}
	public void setStateEnum(StudentStateEnum stateEnum) {
		this.stateEnum = stateEnum;
	}
	@OneToMany(cascade=CascadeType.ALL)
	public List<SkillSet> getSkillSetList() {
		return skillSetList;
	}
	@OneToOne(cascade=CascadeType.ALL)
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public void setSkillSetList(List<SkillSet> skillSetList) {
		this.skillSetList = skillSetList;
	}


}
