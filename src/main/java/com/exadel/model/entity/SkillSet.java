package com.exadel.model.entity;


public class SkillSet extends Student {

    private long skill_Id;
    private String level;

    public SkillSet(){

    }

    public long getSkillId() {
        return skill_Id;
    }

    public void setSkillId(long skill_Id) {
        this.skill_Id = skill_Id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}