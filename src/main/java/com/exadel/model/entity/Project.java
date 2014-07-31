package com.exadel.model.entity;

import com.exadel.model.entity.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    private long id;
    private List<Student> students;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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

    @ManyToMany(mappedBy = "")
    @JoinColumn(name = "students")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
