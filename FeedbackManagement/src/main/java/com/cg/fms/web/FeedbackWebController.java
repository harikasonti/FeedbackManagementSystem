package com.cg.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entity.Feedback;
import com.cg.fms.service.IFeedbackService;

@RestController
@RequestMapping("/app")
public class FeedbackWebController {
	@Autowired
	IFeedbackService service;
	
	@PostMapping("/feedback")
	public boolean addFeedback(@RequestBody Feedback feedback)
	{
		service.addFeedback(feedback);
		return true;
	}
	@DeleteMapping("/feedback/{feedbackId}")
	public boolean removeFeedback(@PathVariable int feedbackId) {
		 return service.removeFeedabck(feedbackId);
	}
	

	@GetMapping("/businessfeedback/{businessId}")
	public List<Feedback> getFeedbackById(@PathVariable int businessId)
	{ 
		return service.getFeedbackById(businessId);
		
	}
	
 
}
