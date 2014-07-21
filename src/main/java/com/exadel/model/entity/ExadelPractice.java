package com.exadel.model.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "exadel_practice")
public class ExadelPractice {
    private String interview; // текст собеседования
    private String  curator;
/*    private boolean work_invitation,practicing;
    private Calendar practice_start,practice_stop;*/

    public ExadelPractice() {
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

/*    @Column(name = "work_invitation")
    public boolean isWork_invitation() {
        return work_invitation;
    }

    public void setWork_invitation(boolean work_invitation) {
        this.work_invitation = work_invitation;
    }

    @Column(name = "practicing")
    public boolean isPracticing() {
        return practicing;
    }

    public void setPracticing(boolean practicing) {
        this.practicing = practicing;
    }

    @Column(name = "practice_start")
    public Calendar getPractice_start() {
        return practice_start;
    }

    public void setPractice_start(Calendar practice_start) {
        this.practice_start = practice_start;
    }

    @Column(name = "practice_stop")
    public Calendar getPractice_stop() {
        return practice_stop;
    }

    public void setPractice_stop(Calendar practice_stop) {
        this.practice_stop = practice_stop;
    }*/

}
