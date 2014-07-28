package com.exadel.model.entity.student;

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
	private Long id;
	private String interview; // текст собеседования
    private String  curator;
    private Boolean workInvitation;
    private Calendar practiceStart;
    private Calendar practiceStop;
    private Boolean onProbation;
    public ExadelPractice() {
    }
    

	public String getCurator() {
		return curator;
	}

	@Id
	@GeneratedValue(generator="foreign")
	@GenericGenerator(name="foreign", strategy = "foreign", parameters={
	@Parameter(name="property", value="student")
	})
	@Column (name="stud_id")
	public Long getId() {
		return id;
	}

	public String getInterview() {
		return interview;
	}

	public Calendar getPracticeStart() {
		return practiceStart;
	}

	public Calendar getPracticeStop() {
		return practiceStop;
	}

	@JsonIgnore
	@OneToOne(optional=false)
	@JoinColumn(name="stud_id")
	public Student getStudent() {
		return student;
	}


	@Column(name="on_probation")
	public Boolean isOnProbation() {
		return onProbation;
	}

	public Boolean isWorkInvitation() {
		return workInvitation;
	}



	public void setCurator(String curator) {
		this.curator = curator;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}

	public void setOnProbation(Boolean onProbation) {
		this.onProbation = onProbation;
	}

	public void setPracticeStart(Calendar practiceStart) {
		this.practiceStart = practiceStart;
	}

	public void setPracticeStop(Calendar practiceStop) {
		this.practiceStop = practiceStop;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	public void setWorkInvitation(Boolean workInvitation) {
		this.workInvitation = workInvitation;
	}



}
