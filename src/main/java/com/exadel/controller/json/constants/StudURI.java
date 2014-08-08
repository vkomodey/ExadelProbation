package com.exadel.controller.json.constants;

public class StudURI {

	public static final String DUMMY_STUDENT = "stud/dummy";
	public static final String DUMMY_STUDENTARRAY = "stud/dummyarr";
	public static final String GET_STUDENT = "stud/{id}";
    public static final String GET_ALL_STUDENT = "stud/all";
    public static final String GET_FEEDBACK_ARRAY= "stud/{id}/feedbacks/get";
	public static final String CREATE_STUDENT = "stud/create";
	public static final String PUSH_FEEDBACK= "stud/{id}/feedbacks/push";
    public static final String EDIT_STUDENT_INFO= "stud/{id}/edit";
	public static final String ATTACH_STUDENT = "stud/{id}/attach_to_curator/{curator_id}";
}
