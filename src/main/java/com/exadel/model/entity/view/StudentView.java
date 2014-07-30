package com.exadel.model.entity.view;


import com.exadel.model.entity.student.Skill;

import java.util.Set;

public class StudentView {

    private String firstName;
    private String secondName;
    private String surname;
    private String email;
    private String skype;
    private String phone;
    private String university;
    private String faculty;
    private String specialty;
    private String course_group;
    private String englishLevel;
    private Set<Skill> skillSet;
    private int graduate_year;
    private double grade;
    private Boolean summer;
    private Integer course;

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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCourse_group() {
        return course_group;
    }

    public void setCourse_group(String course_group) {
        this.course_group = course_group;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public int getGraduate_year() {
        return graduate_year;
    }

    public void setGraduate_year(int graduate_year) {
        this.graduate_year = graduate_year;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Boolean getSummer() {
        return summer;
    }

    public void setSummer(Boolean summer) {
        this.summer = summer;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

}
