package com.exadel.model.entity.student;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.exadel.model.constants.CurrentProjectRoleEnum;
import com.exadel.model.entity.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class ExadelWork {
	private Integer hours_current;
	private Integer hours_desired;
	private Calendar workStartDate;
	private Calendar hoursDesiredTransferDate;
	private Calendar billableStartDate;
	private Calendar vacationNextDateStart;
	private Calendar vacationNextDateEnd;
	private Calendar exadelTrainingNextFrom;
	private Calendar exadelTrainingNextTo;
	private Set<Project> currentProjects;
	private CurrentProjectRoleEnum currentProjectRole;
	private String teamLeadOnCurrent;
	private String curator;
	private String exadelTrainingType;
	private String certificates;
	private Boolean isBillable;
	private Boolean wannaChangeProj;
	private Set<Technology> currentUsedTechnologies;
	private Set<Technology> desiredUsedTechnologies;

	public ExadelWork() {
	}

	public Calendar getBillableStartDate() {
		return billableStartDate;
	}

	public String getCertificates() {
		return certificates;
	}

	public String getCurator() {
		return curator;
	}

	public CurrentProjectRoleEnum getCurrentProjectRole() {
		return currentProjectRole;
	}
    @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "students")
	public Set<Project> getCurrentProjects() {
		return currentProjects;
	}

    @ManyToMany
	@JoinTable(name = "student_current_used_technologies", joinColumns = @JoinColumn(name = "stud_id",
	referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "currentusedtech_id", referencedColumnName = "id"))
	public Set<Technology> getCurrentUsedTechnologies() {
		return currentUsedTechnologies;
	}

	@ManyToMany
	@JoinTable(name = "student_desired_used_technologies", joinColumns = @JoinColumn(name = "stud_id",
	referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "desiredusedtech_id", referencedColumnName = "id"))
	public Set<Technology> getDesiredUsedTechnologies() {
		return desiredUsedTechnologies;
	}

	public Calendar getExadelTrainingNextFrom() {
		return exadelTrainingNextFrom;
	}

	public Calendar getExadelTrainingNextTo() {
		return exadelTrainingNextTo;
	}

	public String getExadelTrainingType() {
		return exadelTrainingType;
	}

	public Integer getHours_current() {
		return hours_current;
	}

	public Integer getHours_desired() {
		return hours_desired;
	}

	public Calendar getHoursDesiredTransferDate() {
		return hoursDesiredTransferDate;
	}

	public Boolean getIsBillable() {
		return isBillable;
	}

	public String getTeamLeadOnCurrent() {
		return teamLeadOnCurrent;
	}

	public Calendar getVacationNextDateEnd() {
		return vacationNextDateEnd;
	}

	public Calendar getVacationNextDateStart() {
		return vacationNextDateStart;
	}

	public Boolean getWannaChangeProj() {
		return wannaChangeProj;
	}

	public Calendar getWorkStartDate() {
		return workStartDate;
	}

	public void setBillable(Boolean isBillable) {
		this.isBillable = isBillable;
	}

	public void setBillableStartDate(Calendar billableStartDate) {
		this.billableStartDate = billableStartDate;
	}

	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public void setCurrentProjectRole(CurrentProjectRoleEnum currentProjectRole) {
		this.currentProjectRole = currentProjectRole;
	}

	public void setCurrentProjects(Set<Project> currentProjects) {
		this.currentProjects = currentProjects;
	}

	public void setCurrentUsedTechnologies(
			Set<Technology> currentUsedTechnologies) {
		this.currentUsedTechnologies = currentUsedTechnologies;
	}

	public void setDesiredUsedTechnologies(
			Set<Technology> desiredUsedTechnologies) {
		this.desiredUsedTechnologies = desiredUsedTechnologies;
	}

	public void setExadelTrainingNextFrom(Calendar exadelTrainingNextFrom) {
		this.exadelTrainingNextFrom = exadelTrainingNextFrom;
	}

	public void setExadelTrainingNextTo(Calendar exadelTrainingNextTo) {
		this.exadelTrainingNextTo = exadelTrainingNextTo;
	}

	public void setExadelTrainingType(String exadelTrainingType) {
		this.exadelTrainingType = exadelTrainingType;
	}

	public void setHours_current(Integer hours_current) {
		this.hours_current = hours_current;
	}

	public void setHours_desired(Integer hours_desired) {
		this.hours_desired = hours_desired;
	}

	public void setHoursDesiredTransferDate(Calendar hoursDesiredTransferDate) {
		this.hoursDesiredTransferDate = hoursDesiredTransferDate;
	}

	public void setIsBillable(Boolean isBillable) {
		this.isBillable = isBillable;
	}

	public void setTeamLeadOnCurrent(String teamLeadOnCurrent) {
		this.teamLeadOnCurrent = teamLeadOnCurrent;
	}

	public void setVacationNextDateEnd(Calendar vacationNextDateEnd) {
		this.vacationNextDateEnd = vacationNextDateEnd;
	}

	public void setVacationNextDateStart(Calendar vacationNextDateStart) {
		this.vacationNextDateStart = vacationNextDateStart;
	}

	public void setWannaChangeProj(Boolean wannaChangeProj) {
		this.wannaChangeProj = wannaChangeProj;
	}

	public void setWorkStartDate(Calendar workStartDate) {
		this.workStartDate = workStartDate;
	}
}
