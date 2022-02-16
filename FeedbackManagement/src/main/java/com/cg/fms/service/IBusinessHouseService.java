package com.cg.fms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.fms.dto.BusinessHouseDTO;
import com.cg.fms.dto.BusinessHouseSavePostDTO;
import com.cg.fms.entity.BusinessHouse;
import com.cg.fms.entity.Feedback;
import com.cg.fms.entity.Product;

@Service
public interface IBusinessHouseService {
	public List<BusinessHouse> getAllBusinessHouse();
	public List<BusinessHouse> getByName(String BusinessName);
	public BusinessHouseDTO saveBusiness(BusinessHouseSavePostDTO b);
	public boolean removeBuisnessHouse(int businessId);
	public BusinessHouse addBuisnessHouse(BusinessHouse businessHouse);
	public List<BusinessHouse> getBusinessHouseOnLocation(String businessLocation);
	
	public boolean calculateAndUpdateRating(int businessId);
	
	public List<BusinessHouse> sortBusinessHouseBasedOnAvgRating();
	
	

}
