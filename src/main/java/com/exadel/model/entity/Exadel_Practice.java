package com.exadel.model.entity;

import java.util.Calendar;

/**
 * Created by Ivan on 17.07.14.
 */
public class Exadel_Practice {
    private long id;
    private String interview,curator;
    private boolean work_invitation,practicing;

    public Exadel_Practice() {
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public boolean isWork_invitation() {
        return work_invitation;
    }

    public void setWork_invitation(boolean work_invitation) {
        this.work_invitation = work_invitation;
    }

    public boolean isPracticing() {
        return practicing;
    }

    public void setPracticing(boolean practicing) {
        this.practicing = practicing;
    }

    public Calendar getPractice_start() {
        return practice_start;
    }

    public void setPractice_start(Calendar practice_start) {
        this.practice_start = practice_start;
    }

    public Calendar getPractice_stop() {
        return practice_stop;
    }

    public void setPractice_stop(Calendar practice_stop) {
        this.practice_stop = practice_stop;
    }

    private Calendar practice_start,practice_stop;
}
