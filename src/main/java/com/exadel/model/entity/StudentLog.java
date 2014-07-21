package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_log")
public class StudentLog {
    private long id;
    private String new_State;

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
    public String getNew_State() {
        return new_State;
    }

    public void setNew_State(String new_State) {
        this.new_State = new_State;
    }
}
