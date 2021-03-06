package com.exadel.model.entity.student;

import com.exadel.model.constants.EnglishEnum;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.User;
import com.exadel.model.entity.join.StudentCuratorJoin;
import com.exadel.model.view.IdNameSurnamePersonView;
import com.exadel.model.view.StudentView;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.*;

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

	private Set<StudentCuratorJoin> curator;

	public Student() {
		super();
		// this.setSkillSet(new HashSet<Skill>());
		// this.setFeedback(new ArrayList<Feedback>());
		// this.setStudy(new Study());
	}

	// @JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	public Set<StudentCuratorJoin> getCurator() {
		return curator;
	}

	public String getEmail() {
		return email;
	}

	@Enumerated(EnumType.STRING)
	public EnglishEnum getEnglish() {
		return english;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	@PrimaryKeyJoinColumn
	@JsonIgnore
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public String getPhone() {
		return phone;
	}

	@Embedded
	public ExadelPractice getPractice() {
		return practice;
	}

	@Override
	@Transient
	@JsonIgnore
	public String getRole() {
		return SpringSecurityRole.STUDENT;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

	@Embedded
	public ExadelWork getWork() {
		return work;
	}

	public void setCurator(Set<StudentCuratorJoin> curator) {
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
		this.practice = practice;
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
		this.work = work;
	}

	public void fromView(StudentView view) {
		this.setFirstName(view.getFirstName());
		this.setMiddleName(view.getMiddleName());
		this.setSurname(view.getSurname());
		if (this.getState() != StudentStateEnum.WORK
				&& view.getState() == StudentStateEnum.WORK) {
			this.setWork(new ExadelWork());
			this.getWork().setWorkStartDate(Calendar.getInstance());
		}
		this.setState(view.getState());

		this.setEmail(view.getEmail());
		this.setPhone(view.getPhone());
		this.setSkype(view.getSkype());

		this.setEnglish(view.getEnglish());
		this.getSkillSet().clear();
		this.getSkillSet().addAll(view.getSkillSet());
		// WOW! SUCH HIBERNATE
		/*for (StudentExams se : this.getStudy().getExams()) {
			se.setStudent(null);
		}*/

		this.getStudy().getExams().clear();
        this.getStudy().fromView(view.getStudy());
        //this.setWork(new ExadelWork());
        //this.getWork().setCurrentProjects(view.getCurrentProjects());
        this.getWork().setBillable(view.getIsBillable());
        this.getWork().setHours_current(view.getHours_current());
		for (StudentExams se : this.getStudy().getExams()) {
			se.setStudent(this);
		}
	}

	public StudentView toView() {
		StudentView view = new StudentView();
		view.setId(this.getId());
		view.setLogin(this.getName());
		view.setFirstName(this.getFirstName());
		view.setMiddleName(this.getMiddleName());
		view.setSurname(this.getSurname());

		view.setEmail(this.getEmail());
		view.setPhone(this.getPhone());
		view.setSkype(this.getSkype());
        view.setState(this.getState());

		view.setEnglish(this.getEnglish());
		view.setSkillSet(this.getSkillSet());
		view.setStudy(this.getStudy().toView());
		view.setIsBillable(this.getWork().getIsBillable());
		view.setHours_current(this.getWork().getHours_current());
        view.setCurrentProjects(this.getWork().getCurrentProjects());
		List<IdNameSurnamePersonView> viewcurators = new ArrayList<IdNameSurnamePersonView>();
		for (StudentCuratorJoin scj : this.getCurator()) {
			viewcurators.add(new IdNameSurnamePersonView(scj.getCurator()));
		}
		view.setCurator(viewcurators);
		return view;
	}
}
