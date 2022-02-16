package com.cg.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.entity.Feedback;

@Service
public interface IFeedbackService {
	public Feedback addFeedback(Feedback feedback);
	public boolean removeFeedabck(int feedbackId);
	public List<Feedback> getFeedbackById(int businessId);

}
