package com.exadel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill_set")
public class SkillSet extends Student {

    private long skill_Id;
    private String level;

    public SkillSet(){

    }

    @Column(name = "skill_id")
    public long getSkillId() {
        return skill_Id;
    }

    public void setSkillId(long skill_Id) {
        this.skill_Id = skill_Id;
    }

    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}