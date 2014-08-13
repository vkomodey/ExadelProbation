package com.exadel.controller.json.constants;

public class TypeURI {

	public static final String GET_ALL_TECHNOLOGIES = "types/technology/get";
    public static final String GET_ALL_STATES = "types/state/get";
    public static final String GET_ALL_FACULTIES = "types/faculty/get";
    public static final String GET_ALL_UNIVERSITIES = "types/university/get";
    public static final String GET_UNIVER_FACULTIES = "types/university/faculties/get";
    
    public static final String PUSH_FACULTY = "types/faculty/push";
    public static final String PUSH_UNIVERSITY = "types/university/push";
	public static final String DELETE_UNIVERSITY = "types/university/{id}/delete";
	public static final String DELETE_FACULTY = "types/faculty/{id}/delete";
	public static final String PUSH_TECHNOLOGY = "types/technology/push";
	public static final String DELETE_TECHNOLOGY = "types/technology/{id}/delete";

}
