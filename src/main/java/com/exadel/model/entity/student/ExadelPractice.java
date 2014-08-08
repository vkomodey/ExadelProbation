package com.exadel.model.entity.student;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExadelPractice{
	private String interview; // текст собеседования
    private Boolean workInvitation;
    private Calendar practiceStart;
    private Calendar practiceStop;
    private Boolean onProbation;
    public ExadelPractice() {
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

	@Column(name="on_probation")
	public Boolean isOnProbation() {
		return onProbation;
	}

	public Boolean isWorkInvitation() {
		return workInvitation;
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


	public void setWorkInvitation(Boolean workInvitation) {
		this.workInvitation = workInvitation;
	}



}
