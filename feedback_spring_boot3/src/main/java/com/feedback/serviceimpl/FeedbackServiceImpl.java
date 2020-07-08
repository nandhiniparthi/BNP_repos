package com.feedback.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDAO;
import com.feedback.exception.BusinessException;
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
	public Feedback getFeedbackbycid(int cid) throws BusinessException {

		if(cid<=0) {
			throw new BusinessException("Id "+cid +" is invalid");
		}
		Feedback feedback=null;
		try {
			feedback=dao.findById(cid).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+cid);
		}
		return feedback;

	}



	@Override
	public List<Feedback> getallfeedbacks() {

		return dao.findAll();
	}

	@Override
	public List<Feedback> getallfeedbackbyrating(int rating)  {
		
		return dao.findByRating(rating);

	}

	@Override
	public void deleteFeedback(int cid) {
		dao.deleteById(cid);;

	}

}