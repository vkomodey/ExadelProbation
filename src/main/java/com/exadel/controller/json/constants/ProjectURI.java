package com.exadel.controller.json.constants;

public class ProjectURI {
    public static final String ADD_PROJECT = "proj/add";
    public static final String REMOVE_PROJECT = "proj/remove/{id}";
    public static final String GET_ALL_PROJECTS = "proj/all";
    public static final String GET_ALL_STUDENTS = "proj/stud/all/{id}";
    public static final String GET_ALL_CURRENT_PROJECT_USED_TECHNOLOGIES = "proj/{id}/techlist";
    public static final String ADD_STUDENT_ON_PROJECT = "proj/{id}/add_stud/{stud_id}";
    public static final String REMOVE_STUDENT_FROM_PROJECT = "proj/{id}/remove_stud/{stud_id}";
}
