package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    public Feedback() {
    }

    @Column(name = "feedbackDate")
    public Calendar getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Calendar feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    @Column(name = "stud_id")
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "profCompetence")
    public boolean isProfCompetence() {
        return profCompetence;
    }

    public void setProfCompetence(boolean profCompetence) {
        this.profCompetence = profCompetence;
    }

    @Column(name = "needMoreHours")
    public boolean isNeedMoreHours() {
        return needMoreHours;
    }

    public void setNeedMoreHours(boolean needMoreHours) {
        this.needMoreHours = needMoreHours;
    }

    @Column(name = "workAttitude")
    public String getWorkAttitude() {
        return workAttitude;
    }

    public void setWorkAttitude(String workAttitude) {
        this.workAttitude = workAttitude;
    }

    @Column(name = "collectiveRelations")
    public String getCollectiveRelations() {
        return collectiveRelations;
    }

    public void setCollectiveRelations(String collectiveRelations) {
        this.collectiveRelations = collectiveRelations;
    }

    @Column(name = "profMattersProgress")
    public String getProfMattersProgress() {
        return profMattersProgress;
    }

    public void setProfMattersProgress(String profMattersProgress) {
        this.profMattersProgress = profMattersProgress;
    }

    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
