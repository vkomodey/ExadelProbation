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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exadel_practice")
public class ExadelPractice{
	private Student student;
	private long id;
	private String interview; // текст собеседования
    private String  curator;
    private boolean workInvitation;
    private Calendar practiceStart;
    private Calendar practiceStop;
    private boolean onProbation;
    public ExadelPractice() {
    }
    

	@JsonIgnore
	@OneToOne(optional=false)
	@JoinColumn(name="stud_id")
	public Student getStudent() {
		return student;
	}

	@Id
	@GeneratedValue(generator="foreign")
	@GenericGenerator(name="foreign", strategy = "foreign", parameters={
	@Parameter(name="property", value="student")
	})
	@Column (name="stud_id")
	public long getId() {
		return id;
	}

	@Column(name="on_probation")
	public boolean isOnProbation() {
		return onProbation;
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


	public Calendar getPracticeStart() {
		return practiceStart;
	}

	public Calendar getPracticeStop() {
		return practiceStop;
	}



	public void setOnProbation(boolean onProbation) {
		this.onProbation = onProbation;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setId(long id) {
		this.id = id;
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


	public void setPracticeStart(Calendar practiceStart) {
		this.practiceStart = practiceStart;
	}

	public void setPracticeStop(Calendar practiceStop) {
		this.practiceStop = practiceStop;
	}



}
