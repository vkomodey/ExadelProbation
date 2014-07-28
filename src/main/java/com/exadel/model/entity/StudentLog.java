package com.exadel.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.student.Student;

@Entity
@Table(name = "student_log")
public class StudentLog {
    private Long id;
    private Student student;
    private StudentStateEnum newState;
    private Calendar time;
	public StudentLog() {
    }
	@Id
    @Column(name = "id",columnDefinition = "serial")
	@Generated(GenerationTime.INSERT)
    public Long getId() {
        return id;
    }
	@Column(name = "new_state")
    public StudentStateEnum getNewState() {
        return newState;
    }
	@ManyToOne
    public Student getStudent() {
		return student;
	}

    public Calendar getTime() {
		return time;
	}
    public void setId(Long id) {
	    this.id = id;
	}

    public void setNewState(StudentStateEnum newState) {
        this.newState = newState;
    }

    public void setStudent(Student student) {
		this.student = student;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
}
