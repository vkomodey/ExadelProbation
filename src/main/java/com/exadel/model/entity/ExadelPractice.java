package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "exadel_practice")
public class ExadelPractice {

    private long id;
    private String interview; // текст собеседования
    private String  curator;
    private boolean workInvitation;
    private boolean practicing;
    private Calendar practiceStart;
    private Calendar practiceStop;

    public ExadelPractice() {
    }

    @Id
    @Column(name = "stud_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "interview")
    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    @Column(name = "curator")
    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    @Column(name = "workInvitation")
    public boolean setWorkInvitation() {
        return workInvitation;
    }

    public void setWorkInvitation(boolean workInvitation) {
        this.workInvitation = workInvitation;
    }

    @Column(name = "practicing")
    public boolean isPracticing() {
        return practicing;
    }

    public void setPracticing(boolean practicing) {
        this.practicing = practicing;
    }

    @Column(name = "practiceStart")
    public Calendar getPracticeStart() {
        return practiceStart;
    }

    public void setPracticeStart(Calendar practiceStart) {
        this.practiceStart = practiceStart;
    }

    @Column(name = "practiceStop")
    public Calendar getPracticeStop() {
        return practiceStop;
    }

    public void setPracticeStop(Calendar practiceStop) {
        this.practiceStop = practiceStop;
    }

}
