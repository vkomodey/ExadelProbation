package com.exadel.model.entity;

import com.exadel.model.enums.CurrentProjectRole;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "exadel_work")
public class ExadelWork {
	private long id;

	private int hours_current;
    private int hours_desired;
    private Calendar hoursDesiredTransferDate;
    private Calendar billableStartDate;
    private Calendar vacationNextDateStart;
    private Calendar vacationNextDateEnd;
    private Calendar exadelTrainingNextFrom;
    private Calendar exadelTrainingNextTo;
    private String currentProject;
    private CurrentProjectRole currentProjectRole;
    private String teamLeadOnCurrent;
    private String curator;
    private String exadelTrainingType;
    private String certificates;
    private boolean isBillable;
    private boolean wannaChangeProj;
    private Set<Technology> projectTechnologies;

    public ExadelWork() {
    }
    @Id
	public long getId() {
		return id;
	}

	public int getHours_current() {
		return hours_current;
	}

	public int getHours_desired() {
		return hours_desired;
	}

	public Calendar getHoursDesiredTransferDate() {
		return hoursDesiredTransferDate;
	}

	public Calendar getBillableStartDate() {
		return billableStartDate;
	}

	public Calendar getVacationNextDateStart() {
		return vacationNextDateStart;
	}

	public Calendar getVacationNextDateEnd() {
		return vacationNextDateEnd;
	}

	public Calendar getExadelTrainingNextFrom() {
		return exadelTrainingNextFrom;
	}

	public Calendar getExadelTrainingNextTo() {
		return exadelTrainingNextTo;
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public CurrentProjectRole getCurrentProjectRole() {
		return currentProjectRole;
	}

	public String getTeamLeadOnCurrent() {
		return teamLeadOnCurrent;
	}

	public String getCurator() {
		return curator;
	}

	public String getExadelTrainingType() {
		return exadelTrainingType;
	}

	public String getCertificates() {
		return certificates;
	}

	public boolean isBillable() {
		return isBillable;
	}

	public boolean isWannaChangeProj() {
		return wannaChangeProj;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	public Set<Technology> getProjectTechnologies() {
		return projectTechnologies;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setHours_current(int hours_current) {
		this.hours_current = hours_current;
	}

	public void setHours_desired(int hours_desired) {
		this.hours_desired = hours_desired;
	}

	public void setHoursDesiredTransferDate(Calendar hoursDesiredTransferDate) {
		this.hoursDesiredTransferDate = hoursDesiredTransferDate;
	}

	public void setBillableStartDate(Calendar billableStartDate) {
		this.billableStartDate = billableStartDate;
	}

	public void setVacationNextDateStart(Calendar vacationNextDateStart) {
		this.vacationNextDateStart = vacationNextDateStart;
	}

	public void setVacationNextDateEnd(Calendar vacationNextDateEnd) {
		this.vacationNextDateEnd = vacationNextDateEnd;
	}

	public void setExadelTrainingNextFrom(Calendar exadelTrainingNextFrom) {
		this.exadelTrainingNextFrom = exadelTrainingNextFrom;
	}

	public void setExadelTrainingNextTo(Calendar exadelTrainingNextTo) {
		this.exadelTrainingNextTo = exadelTrainingNextTo;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public void setCurrentProjectRole(CurrentProjectRole currentProjectRole) {
		this.currentProjectRole = currentProjectRole;
	}

	public void setTeamLeadOnCurrent(String teamLeadOnCurrent) {
		this.teamLeadOnCurrent = teamLeadOnCurrent;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public void setExadelTrainingType(String exadelTrainingType) {
		this.exadelTrainingType = exadelTrainingType;
	}

	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}

	public void setBillable(boolean isBillable) {
		this.isBillable = isBillable;
	}

	public void setWannaChangeProj(boolean wannaChangeProj) {
		this.wannaChangeProj = wannaChangeProj;
	}

	public void setProjectTechnologies(Set<Technology> projectTechnologies) {
		this.projectTechnologies = projectTechnologies;
	}

}
