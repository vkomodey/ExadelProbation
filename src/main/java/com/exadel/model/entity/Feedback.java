package com.exadel.model.entity;

import java.util.Calendar;

/**
 * Created by Ivan on 17.07.14.
 */
public class Feedback {
    private long student_id,id;
    private boolean prof_competence,need_more_hours;
    private String work_attitude,collective_relations,prof_matters_progress;
    private String feedback;

    public Feedback() {
    }

    public Calendar getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(Calendar feedback_date) {
        this.feedback_date = feedback_date;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isProf_competence() {
        return prof_competence;
    }

    public void setProf_competence(boolean prof_competence) {
        this.prof_competence = prof_competence;
    }

    public boolean isNeed_more_hours() {
        return need_more_hours;
    }

    public void setNeed_more_hours(boolean need_more_hours) {
        this.need_more_hours = need_more_hours;
    }

    public String getWork_attitude() {
        return work_attitude;
    }

    public void setWork_attitude(String work_attitude) {
        this.work_attitude = work_attitude;
    }

    public String getCollective_relations() {
        return collective_relations;
    }

    public void setCollective_relations(String collective_relations) {
        this.collective_relations = collective_relations;
    }

    public String getProf_matters_progress() {
        return prof_matters_progress;
    }

    public void setProf_matters_progress(String prof_matters_progress) {
        this.prof_matters_progress = prof_matters_progress;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    private Calendar feedback_date;
}
