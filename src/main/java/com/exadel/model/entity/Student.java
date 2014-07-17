package com.exadel.model.entity;

public class Student extends User{

    private String stateEnum;
    private long id;

    public Student() {

    }

    public String getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(String stateEnum) {
        this.stateEnum = stateEnum;
    }

}
