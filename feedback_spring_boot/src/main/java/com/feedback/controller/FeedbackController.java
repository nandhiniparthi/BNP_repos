package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;
import com.feedback.service.Feedbackservice;

@RestController
public class FeedbackController {

	private MultiValueMap<String, String> map;
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
	public ResponseEntity<Feedback>  getFeedbackbycid(@PathVariable("cid") int cid) {
		
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackbycid(cid),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@GetMapping("/feedbacks")
	public List<Feedback> getallfeedbacks() {
	
		return service.getallfeedbacks();
	}

	
	@GetMapping("/feedback/rating/{rating}")
	public ResponseEntity<Feedback> getallfeedbackbyrating(@PathVariable("rating") int rating) {
		
		try {
			return new ResponseEntity<Feedback>(service.getFeedbackbycid(rating),HttpStatus.OK);
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());
			return new ResponseEntity<Feedback>(null,map, HttpStatus.NOT_FOUND);
		}
		
		//return service.getallfeedbackbyrating(rating);
	}


	@DeleteMapping("/feedback/{cid}")
	public void deleteFeedback(@PathVariable("cid")int cid) {
		service.deleteFeedback(cid);
		
	}


	
	
	
}
