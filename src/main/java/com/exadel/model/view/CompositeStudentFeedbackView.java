package com.exadel.model.view;

import java.util.List;

public class CompositeStudentFeedbackView {
	private List<FeedbackView> feedbacks;
	private StudentView info;
	
	public List<FeedbackView> getFeedbacks() {
		return feedbacks;
	}
	public StudentView getInfo() {
		return info;
	}
	public void setFeedbacks(List<FeedbackView> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public void setInfo(StudentView info) {
		this.info = info;
	}
	
}
