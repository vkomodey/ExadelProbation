package com.exadel.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "exadel_practice")
public class ExadelPractice{
	private long id;
	private String interview; // текст собеседования
    private String  curator;
    private boolean workInvitation;
    private boolean practicing;
    private Calendar practiceStart;
    private Calendar practiceStop;

    public ExadelPractice() {
    }
    @Id
    @GeneratedValue
	public long getId() {
		return id;
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





	public void setId(long id) {
		this.id = id;
	}

}
