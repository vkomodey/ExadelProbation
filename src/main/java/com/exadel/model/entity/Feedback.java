package com.exadel.model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exadel.model.entity.government.Feedbackable;
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
	private Boolean onRealProject;
	private Boolean projectProspect;
	
	private Feedbackable author;

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
	public Feedback(FeedbackView view,Feedbackable feedbackOwner, Student stud){
		this.setAuthor(feedbackOwner);
		this.setStudent(stud);
        if(stud.getWork()!=null){
		this.setBillableNow(stud.getWork().getIsBillable());
        }
        else{
            this.setBillableNow(false);
        }
		
		this.setOnRealProject(view.getWorkInProject());
		if(!this.getOnRealProject()){
			this.setProjectProspect(view.getProspect());
		}
		
		this.setFeedback(view.getOther());
		this.setCollectiveRelations(view.getRelations());
		this.setFeedbackDate(Calendar.getInstance());
		this.setNeedMoreHours(view.isIncreaseHours());
		this.setProfCompetence(view.isProfSuitability());
		this.setProfMattersProgress(view.getProgress());
		this.setWorkAttitude(view.getAttitudeToWork());
		}

	@ManyToOne
	@JoinColumn(name = "author", referencedColumnName = "id",nullable = false)
	public Feedbackable getAuthor() {
		return author;
	}
	public Boolean getBillableNow() {
		return billableNow;
	}
	@Column(name = "collectiveRelations")
	public String getCollectiveRelations() {
		return collectiveRelations;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Column(name = "needMoreHours")
	public Boolean getNeedMoreHours() {
		return needMoreHours;
	}
	public Boolean getOnRealProject() {
		return onRealProject;
	}

	@Column(name = "profCompetence")
	public Boolean getProfCompetence() {
		return profCompetence;
	}

	@Column(name = "profMattersProgress")
	public String getProfMattersProgress() {
		return profMattersProgress;
	}

	public Boolean getProjectProspect() {
		return projectProspect;
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

	public void setAuthor(Feedbackable author) {
		this.author = author;
	}

	public void setBillableNow(Boolean billableNow) {
		this.billableNow = billableNow;
	}
	public void setCollectiveRelations(String collectiveRelations) {
		this.collectiveRelations = collectiveRelations;
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

	public void setOnRealProject(Boolean onRealProject) {
		this.onRealProject = onRealProject;
	}

	public void setProfCompetence(Boolean profCompetence) {
		this.profCompetence = profCompetence;
	}

	public void setProfMattersProgress(String profMattersProgress) {
		this.profMattersProgress = profMattersProgress;
	}

	public void setProjectProspect(Boolean projectProspect) {
		this.projectProspect = projectProspect;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setWorkAttitude(String workAttitude) {
		this.workAttitude = workAttitude;
	}
	public FeedbackView toView() {
		FeedbackView view=new FeedbackView();
		SimpleDateFormat f=new SimpleDateFormat("dd.MM.YYYY");
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
		view.setWorkInProject(getOnRealProject());
		view.setProspect(getProjectProspect());
		view.setDate(f.format(this.getFeedbackDate().getTime()));
		return view;
	}
}
