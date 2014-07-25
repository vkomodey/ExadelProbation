package com.exadel.model.entity.view;


public class FeedbackView {
    private long studId;
    private long id;
    private boolean profSuitability;
    private String attitudeToWork;
    private String relations;
    private String progress;
    private boolean increaseHours;
    private String workInProject;
    private boolean isBillable;
    private String other;
    private String feedbacker;

    FeedbackView() {

    }

    public long getStudId() {
        return studId;
    }

    public void setStudId(long studId) {
        this.studId = studId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isProfSuitability() {
        return profSuitability;
    }

    public void setProfSuitability(boolean profSuitability) {
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

    public boolean isIncreaseHours() {
        return increaseHours;
    }

    public void setIncreaseHours(boolean increaseHours) {
        this.increaseHours = increaseHours;
    }

    public String getWorkInProject() {
        return workInProject;
    }

    public void setWorkInProject(String workInProject) {
        this.workInProject = workInProject;
    }

    public boolean isBillable() {
        return isBillable;
    }

    public void setBillable(boolean isBillable) {
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
