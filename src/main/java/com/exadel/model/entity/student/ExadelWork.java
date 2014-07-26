package com.exadel.model.entity.student;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.exadel.model.constants.CurrentProjectRoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exadel_work")
public class ExadelWork {
	private Student student;
	private Long id;


	private Integer hours_current;
    private Integer hours_desired;
    private Calendar workStartDate;
    private Calendar hoursDesiredTransferDate;
    private Calendar billableStartDate;
    private Calendar vacationNextDateStart;
    private Calendar vacationNextDateEnd;
    private Calendar exadelTrainingNextFrom;
    private Calendar exadelTrainingNextTo;
    private String currentProject;
    private CurrentProjectRoleEnum currentProjectRole;
    private String teamLeadOnCurrent;
    private String curator;
    private String exadelTrainingType;
    private String certificates;
    private Boolean isBillable;
    private Boolean wannaChangeProj;
    private Set<Technology> projectTechnologies;

    public ExadelWork() {
    	this.setProjectTechnologies(new HashSet<Technology>());
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
	
	public String getCurrentProject() {
		return currentProject;
	}

	public CurrentProjectRoleEnum getCurrentProjectRole() {
		return currentProjectRole;
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

	@Id
	@GeneratedValue(generator="foreign")
	@GenericGenerator(name="foreign", strategy = "foreign", parameters={
	@Parameter(name="property", value="student")
	})
	@Column (name="stud_id")
    public Long getId() {
		return id;
	}

	@OneToMany(cascade=CascadeType.ALL)
	public Set<Technology> getProjectTechnologies() {
		return projectTechnologies;
	}

	@JsonIgnore
	@OneToOne(optional=false)
	@JoinColumn(name="stud_id")
	public Student getStudent() {
		return student;
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

	public Calendar getWorkStartDate() {
        return workStartDate;
    }

	public Boolean isBillable() {
		return isBillable;
	}
	
	public Boolean isWannaChangeProj() {
		return wannaChangeProj;
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

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public void setCurrentProjectRole(CurrentProjectRoleEnum currentProjectRole) {
		this.currentProjectRole = currentProjectRole;
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

	public void setId(Long id){
		this.id=id;
	}

	public void setProjectTechnologies(Set<Technology> projectTechnologies) {
		this.projectTechnologies = projectTechnologies;
	}

	public void setStudent(Student student) {
			this.student = student;
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
