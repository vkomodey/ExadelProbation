package com.exadel.model.entity;

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

import com.exadel.model.enums.StudentStateEnum;


@Entity
@Table(name = "student")
public class Student extends User{
	private Study study;
    private StudentStateEnum state;
    private Set<Skill> skillSet;
    private ExadelPractice practice;
    private ExadelWork work;
    private List<Feedback> feedback;
    @OneToMany(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public List<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	private String email;
    private String skype;
    private String phone;
    
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
