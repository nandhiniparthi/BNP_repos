package com.feedback.service;

import java.util.List;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;

public interface Feedbackservice {

	public Feedback createFeedback(Feedback feedback);
	public Feedback updateFeedback(Feedback feedback);
	public Feedback getFeedbackbycid(int cid) throws BusinessException;
	public List<Feedback> getallfeedbacks();
	public List<Feedback> getallfeedbackbyrating(int rating);
	public void deleteFeedback(int id);


}