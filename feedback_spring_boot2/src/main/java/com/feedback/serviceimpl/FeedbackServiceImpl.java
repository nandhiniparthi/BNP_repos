package com.feedback.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDAO;

import com.feedback.model.Feedback;
import com.feedback.service.Feedbackservice;

@Service
public class FeedbackServiceImpl implements Feedbackservice{

	@Autowired
	private FeedbackDAO dao;
	@Override
	public Feedback createFeedback(Feedback feedback) {
		
		return dao.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
	
		return dao.save(feedback);
	}

	

	@Override
	public List<Feedback> getallfeedbacks() {
		
		return dao.findAll();
	}

	@Override
	public List<Feedback> getallfeedbackbyrating(int rating) {
		
		return dao.findByRating(rating);
		
	}

	@Override
	public void deleteFeedback(int cid) {
		dao.deleteById(cid);;
		
	}

	@Override
	public Feedback getFeedbackbycid(int cid) {
		
		return dao.findById(cid).get();
	}

}
