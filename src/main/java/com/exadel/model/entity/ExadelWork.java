package com.exadel.model.entity;

import com.exadel.model.enums.CurrentProjectRole;

import javax.persistence.*;
import java.util.Calendar;

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

    public ExadelWork() {
    }

    @Id
    @Column(name = "stud_id")
    public long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    public CurrentProjectRole getCurrentProjectRole() {
        return currentProjectRole;
    }

    public void setCurrentProjectRole(CurrentProjectRole currentProjectRole) {
        this.currentProjectRole = currentProjectRole;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "hours_current")
    public int getHours_current() {
        return hours_current;
    }

    public void setHours_current(int hours_current) {
        this.hours_current = hours_current;
    }

    @Column(name = "hours_desired")
    public int getHours_desired() {
        return hours_desired;
    }

    public void setHours_desired(int hours_desired) {
        this.hours_desired = hours_desired;
    }

    @Column(name = "hoursDesiredTransferDate")
    public Calendar getHours_desired_transfer_date() {
        return hoursDesiredTransferDate;
    }

    public void setHours_desired_transfer_date(Calendar hoursDesiredTransferDate) {
        this.hoursDesiredTransferDate = hoursDesiredTransferDate;
    }

    @Column(name = "Billable_start_date")
    public Calendar getBillable_start_date() {
        return billableStartDate;
    }

    public void setBillable_start_date(Calendar billableStartDate) {
        this.billableStartDate = billableStartDate;
    }

    @Column(name = "vacationNextDateStart")
    public Calendar getVacation_next_date_start() {
        return vacationNextDateStart;
    }

    public void setVacation_next_date_start(Calendar vacationNextDateStart) {
        this.vacationNextDateStart = vacationNextDateStart;
    }

    @Column(name = "vacationNextDateEnd")
    public Calendar getVacation_next_date_end() {
        return vacationNextDateEnd;
    }

    public void setVacation_next_date_end(Calendar vacationNextDateEnd) {
        this.vacationNextDateEnd = vacationNextDateEnd;
    }

    @Column(name = "exadelTrainingNextFrom")
    public Calendar getExadel_training_next_from() {
        return exadelTrainingNextFrom;
    }

    public void setExadel_training_next_from(Calendar exadelTrainingNextFrom) {
        this.exadelTrainingNextFrom = exadelTrainingNextFrom;
    }

    @Column(name = "exadelTrainingNextTo")
    public Calendar getExadel_training_next_to() {
        return exadelTrainingNextTo;
    }

    public void setExadel_training_next_to(Calendar exadelTrainingNextTo) {
        this.exadelTrainingNextTo = exadelTrainingNextTo;
    }

    @Column(name = "currentProject")
    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    @Column(name = "teamLeadOnCurrent")
    public String getTeam_lead_on_current() {
        return teamLeadOnCurrent;
    }

    public void setTeam_lead_on_current(String teamLeadOnCurrent) {
        this.teamLeadOnCurrent = teamLeadOnCurrent;
    }

    @Column(name = "curator")
    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    @Column(name = "exadelTrainingType")
    public String getExadel_training_next_type() {
        return exadelTrainingType;
    }

    public void setExadel_training_next_type(String exadelTrainingType) {
        this.exadelTrainingType = exadelTrainingType;
    }

    @Column(name = "certificates")
    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    @Column(name = "Isbillable")
    public boolean getIsbillable() {
        return isBillable;
    }

    public void setIsbillable(boolean isBillable) {
        this.isBillable = isBillable;
    }

    @Column(name = "wannaChangeProj")
    public boolean isWanna_change_proj() {
        return wannaChangeProj;
    }

    public void setWanna_change_proj(boolean wannaChangeProj) {
        this.wannaChangeProj = wannaChangeProj;
    }

}
