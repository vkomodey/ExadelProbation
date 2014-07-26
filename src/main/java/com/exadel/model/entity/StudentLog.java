package com.exadel.model.entity;

import com.exadel.model.constants.StudentStateEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_log")
public class StudentLog {
    private Long id;
    private StudentStateEnum newState;

    public StudentLog() {
    }
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "new_state")
    public StudentStateEnum getNewState() {
        return newState;
    }

    public void setId(Long id) {
	    this.id = id;
	}
	public void setNewState(StudentStateEnum newState) {
        this.newState = newState;
    }
}
