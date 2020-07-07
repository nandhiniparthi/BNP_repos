package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.feedback.model.Feedback;
import com.feedback.service.Feedbackservice;

@RestController
public class FeedbackController {

	
	@Autowired
	private Feedbackservice service;
	
	@PostMapping("/feedback")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		
		return service.createFeedback(feedback);
	}


	@PutMapping("/feedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		
		return service.updateFeedback(feedback);
	}


	@GetMapping("/feedback/customerid/{cid}")
	public Feedback  getFeedbackbycid(@PathVariable("cid") int cid) {
		
		return service.getFeedbackbycid(cid);
		
	}
	
	
	@GetMapping("/feedbacks")
	public List<Feedback> getallfeedbacks() {
	
		return service.getallfeedbacks();
	}

	
	@GetMapping("/feedback/rating/{rating}")
	public List<Feedback> getallfeedbackbyrating(@PathVariable("rating") int rating) {
		
		
		
	return service.getallfeedbackbyrating(rating);
	}


	@DeleteMapping("/feedback/{cid}")
	public void deleteFeedback(@PathVariable("cid")int cid) {
		service.deleteFeedback(cid);
		
	}


	
	
	
}
