package com.exadel.controller.json;

public class RestURIConstants {
    public static final String DUMMY_STUDENT = "stud/dummy";
    public static final String GET_STUDENT = "stud/{id}";
    public static final String GET_ALL_STUDENT = "stud/all";
    public static final String GET_SUPERVISED_STUDENTS = "stud/curator/supervised";
    public static final String CREATE_STUDENT = "stud/create";
	public static final String DUMMY_STUDENTARRAY = "stud/dummyarr";
    public static final String PUSH_FEEDBACK= "stud/{id}/feedbacks/push";
    public static final String GET_FEEDBACK_ARRAY= "stud/{id}/feedbacks/get";
	public static final String CREATE_ANYONE = "anyone/create";
    public static final String EDIT_STUDENT_INFO= "stud/{id}/edit";
	public static final String GET_ME = "me";
	public static final String GET_ALL_SKILLTYPE = "types/skill/get";
    public static final String IDENTIFY_ROLE = "me/role";
	public static final String GET_ALL_FILTERED = "stud/filtered";
	public static final String ATTACH_STUDENT = "stud/attach/{id}/{curator_id}";
}
