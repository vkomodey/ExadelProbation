package com.exadel.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exadel.model.entity.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.exadel.model.entity.government.FeedbackAble;

@Entity
@Table(name = "feedback")
public class Feedback {
	private Student student;
	private Long id;
	private Boolean profCompetence;
	private Boolean needMoreHours;
	private String workAttitude;
	private String collectiveRelations;
	private String profMattersProgress;
	private String feedback;
	private Calendar feedbackDate;

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

	@ManyToOne
	@JoinColumn(name = "author", referencedColumnName = "id")
	public FeedbackAble getAuthor() {
		return author;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	public Student getStudent() {
		return student;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Column(name = "feedbackDate")
	public Calendar getFeedbackDate() {
		return feedbackDate;
	}

	@Column(name = "profCompetence")
	public Boolean isProfCompetence() {
		return profCompetence;
	}

	@Column(name = "needMoreHours")
	public Boolean isNeedMoreHours() {
		return needMoreHours;
	}

	@Column(name = "workAttitude")
	public String getWorkAttitude() {
		return workAttitude;
	}

	@Column(name = "collectiveRelations")
	public String getCollectiveRelations() {
		return collectiveRelations;
	}

	@Column(name = "profMattersProgress")
	public String getProfMattersProgress() {
		return profMattersProgress;
	}

	@Column(name = "feedback")
	public String getFeedback() {
		return feedback;
	}

	public void setAuthor(FeedbackAble author) {
		this.author = author;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setFeedbackDate(Calendar feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public void setProfCompetence(Boolean profCompetence) {
		this.profCompetence = profCompetence;
	}

	public void setNeedMoreHours(Boolean needMoreHours) {
		this.needMoreHours = needMoreHours;
	}

	public void setWorkAttitude(String workAttitude) {
		this.workAttitude = workAttitude;
	}

	public void setCollectiveRelations(String collectiveRelations) {
		this.collectiveRelations = collectiveRelations;
	}

	public void setProfMattersProgress(String profMattersProgress) {
		this.profMattersProgress = profMattersProgress;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
