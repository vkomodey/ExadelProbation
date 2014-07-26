package com.exadel.model.entity.view;


public class FeedbackView {
    private Long studId;//
    private Long id;//
    private Boolean profSuitability;//
    private String attitudeToWork;//
    private String relations;//
    private String progress;//
    private Boolean increaseHours;//
    private String workInProject;
    private Boolean isBillable;
    private String other;
    private String feedbacker;//

    public FeedbackView() {

    }

    public Long getStudId() {
        return studId;
    }

    public void setStudId(Long studId) {
        this.studId = studId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isProfSuitability() {
        return profSuitability;
    }

    public void setProfSuitability(Boolean profSuitability) {
        this.profSuitability = profSuitability;
    }

    public String getAttitudeToWork() {
        return attitudeToWork;
    }

    public void setAttitudeToWork(String attitudeToWork) {
        this.attitudeToWork = attitudeToWork;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Boolean isIncreaseHours() {
        return increaseHours;
    }

    public void setIncreaseHours(Boolean increaseHours) {
        this.increaseHours = increaseHours;
    }

    public String getWorkInProject() {
        return workInProject;
    }

    public void setWorkInProject(String workInProject) {
        this.workInProject = workInProject;
    }

    public Boolean isBillable() {
        return isBillable;
    }

    public void setBillable(Boolean isBillable) {
        this.isBillable = isBillable;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getFeedbacker() {
        return feedbacker;
    }

    public void setFeedbacker(String feedbacker) {
        this.feedbacker = feedbacker;
    }
}
