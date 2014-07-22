package com.exadel.model.entity;

import com.exadel.model.enums.StudentStateEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_log")
public class StudentLog {
    private long id;
    private StudentStateEnum newState;

    public StudentLog() {
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "new_state")
    public StudentStateEnum getNewState() {
        return newState;
    }

    public void setNewState(StudentStateEnum newState) {
        this.newState = newState;
    }
}
