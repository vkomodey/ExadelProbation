package com.exadel.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exadel.model.entity.government.FeedbackAble;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.FeedbackView;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "feedback")
public class Feedback {
	private Student student;
	private Long id;
	private Boolean profCompetence;
	private Boolean needMoreHours;
	private Boolean billableNow;
	private String workAttitude;
	private String collectiveRelations;
	private String profMattersProgress;
	private String feedback;
	private Calendar feedbackDate;
	private String currentProject;
	
	private FeedbackAble author;

	public Feedback() {
	}
	public Feedback(Boolean profCompetence, Boolean needMoreHours,
			String workAttitude, String collectiveRelations,
			String profMattersProgress, String feedback, Calendar feedbackDate) {
		this.profCompetence = profCompetence;
		this.needMoreHours = needMoreHours;
		this.workAttitude = workAttitude;
		this.collectiveRelations = collectiveRelations;
		this.profMattersProgress = profMattersProgress;
		this.feedback = feedback;
		this.feedbackDate = feedbackDate;
	}
	public Feedback(FeedbackView view,FeedbackAble feedbackOwner, Student stud){
		this.setAuthor(feedbackOwner);
		this.setStudent(stud);
		this.setBillableNow(stud.getWork().isBillable());
		
		this.setCurrentProject(view.getWorkInProject());
		
		this.setFeedback(view.getOther());
		this.setCollectiveRelations(view.getRelations());
		this.setFeedbackDate(Calendar.getInstance());
		this.setNeedMoreHours(view.isIncreaseHours());
		this.setProfCompetence(view.isProfSuitability());
		this.setProfMattersProgress(view.getProgress());
		this.setWorkAttitude(view.getAttitudeToWork());
		}

	@ManyToOne
	@JoinColumn(name = "author", referencedColumnName = "id")
	public FeedbackAble getAuthor() {
		return author;
	}

	public Boolean getBillableNow() {
		return billableNow;
	}

	@Column(name = "collectiveRelations")
	public String getCollectiveRelations() {
		return collectiveRelations;
	}

	public String getCurrentProject() {
		return currentProject;
	}
	@Column(name = "feedback")
	public String getFeedback() {
		return feedback;
	}

	@Column(name = "feedbackDate")
	public Calendar getFeedbackDate() {
		return feedbackDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Column(name = "needMoreHours")
	public Boolean getNeedMoreHours() {
		return needMoreHours;
	}

	@Column(name = "profCompetence")
	public Boolean getProfCompetence() {
		return profCompetence;
	}

	@Column(name = "profMattersProgress")
	public String getProfMattersProgress() {
		return profMattersProgress;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	public Student getStudent() {
		return student;
	}

	@Column(name = "workAttitude")
	public String getWorkAttitude() {
		return workAttitude;
	}
	public void setAuthor(FeedbackAble author) {
		this.author = author;
	}
	public void setBillableNow(Boolean billableNow) {
		this.billableNow = billableNow;
	}

	public void setCollectiveRelations(String collectiveRelations) {
		this.collectiveRelations = collectiveRelations;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setFeedbackDate(Calendar feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNeedMoreHours(Boolean needMoreHours) {
		this.needMoreHours = needMoreHours;
	}

	public void setProfCompetence(Boolean profCompetence) {
		this.profCompetence = profCompetence;
	}

	public void setProfMattersProgress(String profMattersProgress) {
		this.profMattersProgress = profMattersProgress;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setWorkAttitude(String workAttitude) {
		this.workAttitude = workAttitude;
	}
	public FeedbackView toView() {
		FeedbackView view=new FeedbackView();
		view.setId(getId());
		view.setAttitudeToWork(getWorkAttitude());
		view.setBillable(getBillableNow());
		view.setFeedbacker(getAuthor().getFullName());
		view.setIncreaseHours(getNeedMoreHours());
		view.setOther(getFeedback());
		view.setProfSuitability(getProfCompetence());
		view.setProgress(getProfMattersProgress());
		view.setRelations(getCollectiveRelations());
		view.setStudId(getStudent().getId());
		view.setWorkInProject(getCurrentProject());
		return view;
	}
}
