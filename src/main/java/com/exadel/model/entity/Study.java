package com.exadel.model.entity;

/**
 * Created by Ivan on 17.07.14.
 */
public class Study {
    private long student_id;
    private int graduate_year;
    private String university, faculty, specialty, course_group;

    public Study() {
    }

    public Study(int student_id, int graduate_year, String university, String faculty, String specialty, String course_group) {

        this.student_id = student_id;
        this.graduate_year = graduate_year;
        this.university = university;
        this.faculty = faculty;
        this.specialty = specialty;
        this.course_group = course_group;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public int getGraduate_year() {
        return graduate_year;
    }

    public void setGraduate_year(int graduate_year) {
        this.graduate_year = graduate_year;
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

}
