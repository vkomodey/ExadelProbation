package com.exadel.model.entity;

import com.exadel.model.entity.student.Student;

import javax.persistence.*;

@Entity
@Table(name="project_history")
public class ProjectHistory {
    private long id;
    private String title;
    private Student student;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
