package com.exadel.model.entity;


/**
 * Created by Ivan on 17.07.14.
 */
public class SkillType {
    private long skill_type_id;
    private String name;

    public SkillType() {
    }

    public SkillType(int skill_type_id, String name) {
        this.skill_type_id = skill_type_id;
        this.name = name;
    }

    public long getSkill_type_id() {
        return skill_type_id;
    }

    public void setSkill_type_id(long skill_type_id) {
        this.skill_type_id = skill_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
