package com.cg.fms.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.fms.entity.BusinessHouse;
import com.cg.fms.entity.Feedback;

@Repository
public interface CustomBusinessHouseRepository {
	public List<BusinessHouse> getByName(String businessName);
	public List<BusinessHouse> getBusinessHouseByLocation(String businessLocation);
	
	public List<BusinessHouse> getBusinessHouseById(int businessId);
	
	public boolean updateRatingById(double avgRating,int businessId);
	
}
