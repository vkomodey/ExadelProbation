package com.exadel.model.entity.government;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.exadel.model.entity.Feedback;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class FeedbackAble extends Government {
	private List<Feedback> feedback;

	public FeedbackAble() {
		super();
		this.setFeedback(new ArrayList<Feedback>());
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy="author")
	//@Column(name="feedback")
    @JsonIgnore
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

}
