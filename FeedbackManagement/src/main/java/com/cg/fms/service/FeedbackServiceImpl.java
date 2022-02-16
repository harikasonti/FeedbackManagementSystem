package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entity.Feedback;
import com.cg.fms.repository.IFeedbackRepository;
import com.cg.fms.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackRepository repository;
	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return repository.save(feedback);
	}

	@Override
	public boolean removeFeedabck(int feedbackId) {
		// TODO Auto-generated method stub
		repository.deleteById(feedbackId);
		return true;
	}
	
	@Override
	public List<Feedback> getFeedbackById(int businessId) {
		// TODO Auto-generated method stub
		return repository.getFeedbackById(businessId);
	}

	
}
