package com.exadel.model.entity.government;

import com.exadel.model.entity.Feedback;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class FeedbackAble extends Government {
	private List<Feedback> feedback;

	public FeedbackAble() {
		super();
		this.setFeedback(new ArrayList<Feedback>());
	}

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name="feedback")
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

}
