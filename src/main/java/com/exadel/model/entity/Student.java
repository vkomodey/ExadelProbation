package com.exadel.model.entity;

public class Student extends User{

    private String stateEnum;
    private long id;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student() {

    }

    public String getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(String stateEnum) {
        this.stateEnum = stateEnum;
    }

}
