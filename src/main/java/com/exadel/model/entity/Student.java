package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User{

    private String stateEnum;
    private long id;

    public Student() {

    }

    @Column(name = "stud_id")
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    @Column(name = "state_enum")
    public String getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(String stateEnum) {
        this.stateEnum = stateEnum;
    }

}
