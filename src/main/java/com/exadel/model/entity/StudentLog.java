package com.exadel.model.entity;

/**
 * Created by Ivan on 17.07.14.
 */

public class StudentLog {
    private long id;
    private String new_State;

    public StudentLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNew_State() {
        return new_State;
    }

    public void setNew_State(String new_State) {
        this.new_State = new_State;
    }
}
