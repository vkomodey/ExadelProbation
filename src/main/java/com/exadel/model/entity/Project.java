package com.exadel.model.entity;

import com.exadel.model.entity.student.ExadelWork;
import com.exadel.model.entity.student.Student;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    private long id;
    private Set<ExadelWork> students;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany
    public Set<ExadelWork> getStudents() {
        return students;
    }

    public void setStudents(Set<ExadelWork> students) {
        this.students = students;
    }
}
