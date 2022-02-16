package com.cg.fms.customsort;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.cg.fms.entity.BusinessHouse;

@Component
public class ByAvgRating implements Comparator<BusinessHouse>{

	@Override
	public int compare(BusinessHouse b1, BusinessHouse b2) {
		// TODO Auto-generated method stub
		return Double.compare(b2.getAvgRating(),b1.getAvgRating());
	}
	
	

}
