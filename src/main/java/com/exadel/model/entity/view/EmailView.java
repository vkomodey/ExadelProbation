package com.exadel.model.entity.view;

import java.util.List;


public class EmailView {
    private List<Long> id;
    private String message;

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
