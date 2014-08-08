package com.exadel.model.view;


import java.util.Set;

import java.util.List;

import com.exadel.model.constants.EnglishEnum;
import com.exadel.model.constants.StudentStateEnum;
import com.exadel.model.entity.student.Skill;
import com.exadel.model.entity.student.Study;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StudentView {

    private List<IdNameSurnamePersonView> curator;
    private String email;
    private EnglishEnum english;
    private String firstName;
    private String phone;
    private String secondName;
    private Set<Skill> skillSet;
    private String skype;
    
    private StudentStateEnum state;
    private Study study;
    private String surname;
    private Integer hours_current;
    private Boolean isBillable;
    
    public Integer getHours_current() {
		return hours_current;
	}

	public Boolean getIsBillable() {
		return isBillable;
	}

	public void setHours_current(Integer hours_current) {
		this.hours_current = hours_current;
	}

	public void setIsBillable(Boolean isBillable) {
		this.isBillable = isBillable;
	}

	public List<IdNameSurnamePersonView> getCurator() {
		return curator;
	}

    public String getEmail() {
        return email;
    }

    public EnglishEnum getEnglish() {
        return english;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getSecondName() {
        return secondName;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public String getSkype() {
        return skype;
    }

    public StudentStateEnum getState() {
        return state;
    }

    public Study getStudy() {
        return study;
    }

    public String getSurname() {
        return surname;
    }

    public void setCurator(List<IdNameSurnamePersonView> curator) {
		this.curator = curator;
	}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnglish(EnglishEnum englishLevel) {
        this.english = englishLevel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }


    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setState(StudentStateEnum state) {
        this.state = state;
    }

	public void setStudy(Study study) {
        this.study = study;
    }

	public void setSurname(String surname) {
        this.surname = surname;
    }

}