package com.exadel.model.view;


import com.exadel.model.constants.StudentStateEnum;

import java.util.Calendar;

public class StudentStateView {

    private StudentStateEnum state;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public StudentStateEnum getState() {
        return state;
    }

    public void setState(StudentStateEnum state) {
        this.state = state;
    }
}
