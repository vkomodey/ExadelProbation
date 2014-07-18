package com.exadel.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill_type")
public class SkillType {
    private long skill_type_id;
    private String name;

    public SkillType() {
    }

    public SkillType(int skill_type_id, String name) {
        this.skill_type_id = skill_type_id;
        this.name = name;
    }

    @Column(name = "skill_id")
    public long getSkill_type_id() {
        return skill_type_id;
    }

    public void setSkill_type_id(long skill_type_id) {
        this.skill_type_id = skill_type_id;
    }

    @Column(name = "skill_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
