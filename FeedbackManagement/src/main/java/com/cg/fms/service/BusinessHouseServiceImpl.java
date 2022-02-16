package com.cg.fms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.customsort.ByAvgRating;
import com.cg.fms.dto.BusinessHouseDTO;
import com.cg.fms.dto.BusinessHouseSavePostDTO;
import com.cg.fms.entity.BusinessHouse;
import com.cg.fms.entity.Feedback;
import com.cg.fms.entity.Product;
import com.cg.fms.repository.IBusinessHouseRepository;
import com.cg.fms.util.BusinessDTOConversionClass;


@Service
public class BusinessHouseServiceImpl implements IBusinessHouseService{
	@Autowired
	IBusinessHouseRepository repository;
	
	@Autowired
	BusinessDTOConversionClass dtoConvertion;
	
	@Autowired
	ByAvgRating sortByRatingHigherToLower;
	
	@Override
	@Transactional
	public BusinessHouse addBuisnessHouse(BusinessHouse businessHouse) {
		// TODO Auto-generated method stub
		
		return repository.save(businessHouse);
	}

	@Override
	@Transactional
	public boolean removeBuisnessHouse(int businessId) {
		// TODO Auto-generated method stub
		repository.deleteById(businessId);
		return true;
	}

	@Override
	public List<BusinessHouse> getAllBusinessHouse() {
		// TODO Auto-generated method stub
		List<BusinessHouse> list=(List<BusinessHouse>) repository.findAll();
		return list;
	}

	@Override
	public BusinessHouseDTO saveBusiness(BusinessHouseSavePostDTO businessDto) {
		// TODO Auto-generated method stub
		BusinessHouse b=dtoConvertion.getBusinessFromPostBusinessDTO(businessDto);
		BusinessHouse savedObj=repository.save(b);
		BusinessHouseDTO dtoObj=dtoConvertion.getBusinessHouseDTO(savedObj);
		
		return dtoObj;
	}

	@Override
	public List<BusinessHouse> getByName(String businessName) {
		// TODO Auto-generated method stub
		return repository.getByName(businessName);
	}

	@Override
	public List<BusinessHouse> getBusinessHouseOnLocation(String businessLocation) {
		// TODO Auto-generated method stub
		return repository.getBusinessHouseByLocation(businessLocation);
	}

	@Override
	public boolean calculateAndUpdateRating(int businessId) {
		// TODO Auto-generated method stub
	    List<BusinessHouse> list=repository.getBusinessHouseById(businessId);
	    
	    List<Feedback> list1=  list.get(0).getFeedback();
		
	    List<Integer> list2=new ArrayList<Integer>();
		for(int i=0;i<list1.size();i++) {
			list2.add(list1.get(i).getRating());
		}
		
		double avgRating = list2.stream().mapToDouble(num -> num).average().getAsDouble();
		
	    return repository.updateRatingById(avgRating, businessId);
		
	}

	@Override
	public List<BusinessHouse> sortBusinessHouseBasedOnAvgRating() {
		// TODO Auto-generated method stub
		List<BusinessHouse> list=getAllBusinessHouse();
		Collections.sort(list, sortByRatingHigherToLower);
		return list;
	}

	
	

}
