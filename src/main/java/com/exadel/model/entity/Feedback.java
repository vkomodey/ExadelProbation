package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import java.util.Calendar;

@Entity
@Table(name = "feedback")
public class Feedback {
    private long studentId;
    private long id;
    private boolean profCompetence;
    private boolean needMoreHours;
    private String workAttitude;
    private String collectiveRelations;
    private String profMattersProgress;
    private String feedback;
    private Calendar feedbackDate;
    /*private User author;*/
    
    public Feedback() {
	}
/*
	@ManyToOne
	@JoinColumn(name="author",referencedColumnName="id")
    public User getAuthor() {
		return author;
	}*/

	@Id
	@Column(name = "id")
	public long getId() {
	    return id;
	}

	@Column(name = "feedbackDate")
    public Calendar getFeedbackDate() {
        return feedbackDate;
    }

    @Column(name = "stud_id")
    public long getStudentId() {
        return studentId;
    }

    @Column(name = "profCompetence")
	public boolean isProfCompetence() {
	    return profCompetence;
	}

	@Column(name = "needMoreHours")
	public boolean isNeedMoreHours() {
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

	public void setId(long id) {
		this.id = id;
	}

	public void setFeedbackDate(Calendar feedbackDate) {
	    this.feedbackDate = feedbackDate;
	}

/*	public void setAuthor(User author) {
		this.author = author;
	}
*/
	public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public void setProfCompetence(boolean profCompetence) {
        this.profCompetence = profCompetence;
    }

    public void setNeedMoreHours(boolean needMoreHours) {
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
