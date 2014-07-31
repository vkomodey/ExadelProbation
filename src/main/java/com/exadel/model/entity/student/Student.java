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
import javax.persistence.ManyToOne;
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
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.view.StudentView;
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

    private Curator curator;

    public Student() {
		super();
		this.setSkillSet(new HashSet<Skill>());
		this.setFeedback(new ArrayList<Feedback>());
		this.setStudy(new Study());
	}
    //@JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curator", referencedColumnName = "id")
    public Curator getCurator() {
        return curator;
    }
	public String getEmail() {
		return email;
	}
	@Enumerated(EnumType.STRING)
	public EnglishEnum getEnglish() {
		return english;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="student")
	@PrimaryKeyJoinColumn
	@JsonIgnore
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public String getPhone() {
		return phone;
	}

	@OneToOne(cascade = CascadeType.ALL, optional=true,orphanRemoval=true)
	@JoinColumn (name="id", nullable=false)
	public ExadelPractice getPractice() {
		return practice;
	}
	@Override
    @Transient
    @JsonIgnore
    public String getRole(){
    	return SpringSecurityRole.STUDENT;
    }
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    public Set<Skill> getSkillSet() {
		return skillSet;
	}

	public String getSkype() {
		return skype;
	}
	@Enumerated(EnumType.STRING)
	public StudentStateEnum getState() {
		return state;
	}
	@Embedded
	public Study getStudy() {
		return study;
	}
	@OneToOne(cascade = CascadeType.ALL, optional=true,orphanRemoval=true)
	@JoinColumn (name="id", nullable=false)
	public ExadelWork getWork() {
		return work;
	}
	public void setCurator(Curator curator) {
        this.curator = curator;
    }
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEnglish(EnglishEnum english) {
		this.english = english;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPractice(ExadelPractice practice) {
		if(practice !=null ){
		this.practice = practice;
		this.practice.setStudent(this);
		}
	}
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public void setState(StudentStateEnum state) {
		this.state = state;
	}

    public void setStudy(Study study) {
		this.study = study;
	}

    public void setWork(ExadelWork work) {
		if(practice !=null ){
		this.work = work;
		this.work.setStudent(this);
		}
	}
	public void fromView(StudentView view) {
		this.setFirstName(view.getFirstName());
		this.setSecondName(view.getSecondName());
		this.setSurname(view.getSurname());
		
		this.setEmail(view.getEmail());
		this.setPhone(view.getPhone());
		this.setSkype(view.getSkype());
		
		this.setEnglish(view.getEnglish());
		this.setSkillSet(view.getSkillSet());
		this.setStudy(view.getStudy());
	}
	public StudentView toView() {
		StudentView view=new StudentView();
		view.setFirstName(this.getFirstName());
		view.setSecondName(this.getSecondName());
		view.setSurname(this.getSurname());
		
		view.setEmail(this.getEmail());
		view.setPhone(this.getPhone());
		view.setSkype(this.getSkype());
		
		view.setEnglish(this.getEnglish());
		view.setSkillSet(this.getSkillSet());
		view.setStudy(this.getStudy());
		return view;
	}
}
