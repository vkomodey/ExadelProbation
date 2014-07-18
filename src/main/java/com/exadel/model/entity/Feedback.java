package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "feedback")
public class Feedback {
    private long student_id,id;
    private boolean prof_competence,need_more_hours;
    private String work_attitude,collective_relations,prof_matters_progress;
    private String feedback;
    private Calendar feedback_date;

    public Feedback() {
    }

    @Column(name = "feedback_date")
    public Calendar getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(Calendar feedback_date) {
        this.feedback_date = feedback_date;
    }

    @Column(name = "stud_id")
    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "prof_competence")
    public boolean isProf_competence() {
        return prof_competence;
    }

    public void setProf_competence(boolean prof_competence) {
        this.prof_competence = prof_competence;
    }

    @Column(name = "need_more_hours")
    public boolean isNeed_more_hours() {
        return need_more_hours;
    }

    public void setNeed_more_hours(boolean need_more_hours) {
        this.need_more_hours = need_more_hours;
    }

    @Column(name = "work_attitude")
    public String getWork_attitude() {
        return work_attitude;
    }

    public void setWork_attitude(String work_attitude) {
        this.work_attitude = work_attitude;
    }

    @Column(name = "collective_relations")
    public String getCollective_relations() {
        return collective_relations;
    }

    public void setCollective_relations(String collective_relations) {
        this.collective_relations = collective_relations;
    }

    @Column(name = "prof_matters_progress")
    public String getProf_matters_progress() {
        return prof_matters_progress;
    }

    public void setProf_matters_progress(String prof_matters_progress) {
        this.prof_matters_progress = prof_matters_progress;
    }

    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
