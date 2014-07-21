package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Calendar;

@Entity
@Table(name = "exadel_work")
public class Exadel_Work {
    private long id;
    private int hours_current;
    private int hours_desired;
    private Calendar hours_desired_transfer_date, billable_start_date, vacation_next_date_start, vacation_next_date_end, exadel_training_next_from, exadel_training_next_to;
    private String current_project, current_project_role, team_lead_on_current, curator, exadel_training_next_type, certificates;
    private boolean is_billable, wanna_change_proj;

    public Exadel_Work() {
    }
    @Id
    @Column(name = "stud_id")
    public long getId() {
        return id;
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

    @Column(name = "hours_desired_transfer_date")
    public Calendar getHours_desired_transfer_date() {
        return hours_desired_transfer_date;
    }

    public void setHours_desired_transfer_date(Calendar hours_desired_transfer_date) {
        this.hours_desired_transfer_date = hours_desired_transfer_date;
    }

    @Column(name = "billable_start_date")
    public Calendar getBillable_start_date() {
        return billable_start_date;
    }

    public void setBillable_start_date(Calendar billable_start_date) {
        this.billable_start_date = billable_start_date;
    }

    @Column(name = "vacation_next_date_start")
    public Calendar getVacation_next_date_start() {
        return vacation_next_date_start;
    }

    public void setVacation_next_date_start(Calendar vacation_next_date_start) {
        this.vacation_next_date_start = vacation_next_date_start;
    }

    @Column(name = "vacation_next_date_end")
    public Calendar getVacation_next_date_end() {
        return vacation_next_date_end;
    }

    public void setVacation_next_date_end(Calendar vacation_next_date_end) {
        this.vacation_next_date_end = vacation_next_date_end;
    }

    @Column(name = "exadel_training_next_from")
    public Calendar getExadel_training_next_from() {
        return exadel_training_next_from;
    }

    public void setExadel_training_next_from(Calendar exadel_training_next_from) {
        this.exadel_training_next_from = exadel_training_next_from;
    }

    @Column(name = "exadel_training_next_to")
    public Calendar getExadel_training_next_to() {
        return exadel_training_next_to;
    }

    public void setExadel_training_next_to(Calendar exadel_training_next_to) {
        this.exadel_training_next_to = exadel_training_next_to;
    }

    @Column(name = "current_project")
    public String getCurrent_project() {
        return current_project;
    }

    public void setCurrent_project(String current_project) {
        this.current_project = current_project;
    }

    @Column(name = "current_project_role")
    public String getCurrent_project_role() {
        return current_project_role;
    }

    public void setCurrent_project_role(String current_project_role) {
        this.current_project_role = current_project_role;
    }

    @Column(name = "team_lead_on_current")
    public String getTeam_lead_on_current() {
        return team_lead_on_current;
    }

    public void setTeam_lead_on_current(String team_lead_on_current) {
        this.team_lead_on_current = team_lead_on_current;
    }

    @Column(name = "curator")
    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    @Column(name = "exadel_training_next_type")
    public String getExadel_training_next_type() {
        return exadel_training_next_type;
    }

    public void setExadel_training_next_type(String exadel_training_next_type) {
        this.exadel_training_next_type = exadel_training_next_type;
    }

    @Column(name = "certificates")
    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    @Column(name = "is_billable")
    public boolean isIs_billable() {
        return is_billable;
    }

    public void setIs_billable(boolean is_billable) {
        this.is_billable = is_billable;
    }

    @Column(name = "wanna_change_proj")
    public boolean isWanna_change_proj() {
        return wanna_change_proj;
    }

    public void setWanna_change_proj(boolean wanna_change_proj) {
        this.wanna_change_proj = wanna_change_proj;
    }

}
