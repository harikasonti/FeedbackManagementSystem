package com.cg.fms.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.fms.entity.Feedback;

@Repository
public interface CustomFeedbackRepository {
	
	public List<Feedback> getFeedbackById(int businessId);
	

}
