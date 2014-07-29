package com.exadel.model.entity.view;


public class FeedbackView {
    private Long studId;//
    private Long id;//
    private Boolean profSuitability;//
    private String attitudeToWork;//
    private String relations;//
    private String progress;//
    private Boolean increaseHours;//
    private Boolean prospect;
    private Boolean workInProject;
    private Boolean isBillable;
    private String other;
    private String feedbacker;//
    private String date;

    public FeedbackView() {

    }

    public String getAttitudeToWork() {
        return attitudeToWork;
    }

    public String getFeedbacker() {
        return feedbacker;
    }

    public Long getId() {
        return id;
    }

    public String getOther() {
        return other;
    }

    public String getProgress() {
        return progress;
    }

    public String getRelations() {
        return relations;
    }

    public String getDate() {
        return date;
    }

    public Long getStudId() {
        return studId;
    }

    public Boolean getWorkInProject() {
        return workInProject;
    }

    public Boolean isBillable() {
        return isBillable;
    }

    public Boolean isIncreaseHours() {
        return increaseHours;
    }

    public Boolean isProfSuitability() {
        return profSuitability;
    }

    public Boolean getProspect() {
        return prospect;
    }

    public void setAttitudeToWork(String attitudeToWork) {
        this.attitudeToWork = attitudeToWork;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBillable(Boolean isBillable) {
        this.isBillable = isBillable;
    }

    public void setFeedbacker(String feedbacker) {
        this.feedbacker = feedbacker;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIncreaseHours(Boolean increaseHours) {
        this.increaseHours = increaseHours;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setProfSuitability(Boolean profSuitability) {
        this.profSuitability = profSuitability;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public void setProspect(Boolean prospect) {
        this.prospect = prospect;
    }

    public void setStudId(Long studId) {
        this.studId = studId;
    }

    public void setWorkInProject(Boolean workInProject) {
        this.workInProject = workInProject;
    }
}
