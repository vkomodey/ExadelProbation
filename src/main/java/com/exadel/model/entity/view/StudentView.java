package com.exadel.model.entity.view;


import com.exadel.model.constants.EnglishEnum;
import com.exadel.model.entity.student.Skill;
import com.exadel.model.entity.student.Study;

import java.util.Set;

public class StudentView {

    private String firstName;
    private String secondName;
    private String surname;
    private String email;
    private String skype;
    private String phone;
    private EnglishEnum englishLevel;
    private Set<Skill> skillSet;
    private Study study;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public EnglishEnum getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishEnum englishLevel) {
        this.englishLevel = englishLevel;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

}