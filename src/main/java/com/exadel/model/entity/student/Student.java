package com.exadel.model.entity.student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.exadel.model.constants.EnglishEnum;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "student")
public class Student extends User {
	private Study study;
    private StudentStateEnum state;
    private Set<Skill> skillSet;
    private ExadelPractice practice;
    private ExadelWork work;
    private List<Feedback> feedback;
    private EnglishEnum english;
    private String email;
    private String skype;
    private String phone;
    
    @Override
    @Transient
    @JsonIgnore
    public String getRole(){
    	return SpringSecurityRole.STUDENT;
    }
    @Enumerated(EnumType.STRING)
	public EnglishEnum getEnglish() {
		return english;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public String getEmail() {
		return email;
	}
	public String getSkype() {
		return skype;
	}
	public String getPhone() {
		return phone;
	}
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    public Set<Skill> getSkillSet() {
		return skillSet;
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
	@OneToOne(cascade = CascadeType.ALL, optional=true,orphanRemoval=true)
	@JoinColumn (name="id", nullable=false)
	public ExadelPractice getPractice() {
		return practice;
	}
	@OneToOne(cascade = CascadeType.ALL, optional=true,orphanRemoval=true)
	@JoinColumn (name="id", nullable=false)
	public ExadelWork getWork() {
		return work;
	}
	public void setEnglish(EnglishEnum english) {
		this.english = english;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public void setPractice(ExadelPractice practice) {
		this.practice = practice;
		this.practice.setStudent(this);
	}
	
	public void setWork(ExadelWork work) {
		this.work = work;
		this.work.setStudent(this);
	}
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	public Student() {
		super();
		this.setSkillSet(new HashSet<Skill>());
		this.setFeedback(new ArrayList<Feedback>());
		this.setStudy(new Study());
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
