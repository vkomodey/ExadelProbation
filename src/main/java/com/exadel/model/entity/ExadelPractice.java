package com.exadel.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "exadel_practice")
public class ExadelPractice{
	private Student student;
	
	@OneToOne(optional=false)
	@JoinColumn(name="stud_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private long id;
	@Id
	@GeneratedValue(generator="foreign")
	@GenericGenerator(name="foreign", strategy = "foreign", parameters={
	@Parameter(name="property", value="student")
	})
	@Column (name="stud_id")
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String interview; // текст собеседования
    private String  curator;
    private boolean workInvitation;
    private boolean practicing;
    private Calendar practiceStart;
    private Calendar practiceStop;

    public ExadelPractice() {
    }
    

	public String getInterview() {
		return interview;
	}

	public String getCurator() {
		return curator;
	}

	public boolean isWorkInvitation() {
		return workInvitation;
	}

	public boolean isPracticing() {
		return practicing;
	}

	public Calendar getPracticeStart() {
		return practiceStart;
	}

	public Calendar getPracticeStop() {
		return practiceStop;
	}



	public void setInterview(String interview) {
		this.interview = interview;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public void setWorkInvitation(boolean workInvitation) {
		this.workInvitation = workInvitation;
	}

	public void setPracticing(boolean practicing) {
		this.practicing = practicing;
	}

	public void setPracticeStart(Calendar practiceStart) {
		this.practiceStart = practiceStart;
	}

	public void setPracticeStop(Calendar practiceStop) {
		this.practiceStop = practiceStop;
	}



}
