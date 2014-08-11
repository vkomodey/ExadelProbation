package com.exadel.model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.*;

import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.student.Student;
import com.exadel.model.view.StudentStateView;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
	@Column(name = "new_state")
    @Enumerated(EnumType.STRING)
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

    public StudentStateView toView() {
        StudentStateView view=new StudentStateView();
        SimpleDateFormat f=new SimpleDateFormat("dd.MM.YYYY");
        view.setState(getNewState());
        view.setTime(f.format(this.getTime().getTime()));
        return view;
    }
}
