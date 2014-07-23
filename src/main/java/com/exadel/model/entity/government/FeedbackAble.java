package com.exadel.model.entity.government;

import com.exadel.model.entity.Feedback;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public abstract class FeedbackAble extends Government {
	private List<Feedback> feedback;

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name="feedback")
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public FeedbackAble() {
		super();
		this.setFeedback(new ArrayList<Feedback>());
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

}
