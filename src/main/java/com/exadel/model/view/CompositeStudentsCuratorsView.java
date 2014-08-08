package com.exadel.model.view;

import java.util.List;

public class CompositeStudentsCuratorsView {
    List<Long> studsId;
    List<Long> cursId;

    public CompositeStudentsCuratorsView() {
    }

    public CompositeStudentsCuratorsView(List<Long> studsId, List<Long> cursId) {
        this.studsId = studsId;
        this.cursId = cursId;
    }

    public List<Long> getStudsId() {
        return studsId;
    }

    public void setStudsId(List<Long> studsId) {
        this.studsId = studsId;
    }

    public List<Long> getCursId() {
        return cursId;
    }

    public void setCursId(List<Long> cursId) {
        this.cursId = cursId;
    }
}
