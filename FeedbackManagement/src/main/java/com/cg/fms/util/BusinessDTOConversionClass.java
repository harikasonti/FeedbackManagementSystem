package com.cg.fms.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.cg.fms.dto.BusinessHouseDTO;
import com.cg.fms.dto.BusinessHouseSavePostDTO;
import com.cg.fms.entity.BusinessHouse;

@Component
public class BusinessDTOConversionClass {
	public BusinessHouseDTO getBusinessHouseDTO(BusinessHouse businessHouse) {
		BusinessHouseDTO dtoObj=new BusinessHouseDTO();
		dtoObj.setBusinessName(businessHouse.getBusinessName());
		dtoObj.setBusinessCategory(businessHouse.getBusinessCategory());
		dtoObj.setBusinessLocation(businessHouse.getBusinessLocation());
		dtoObj.setAvgRating(businessHouse.getAvgRating());
		dtoObj.setCommunicationId(new Random().nextInt(5000));
		return dtoObj;
	}
	
	public BusinessHouse getBusinessFromPostBusinessDTO(BusinessHouseSavePostDTO dto) {
		BusinessHouse b=new BusinessHouse();
		b.setBusinessName(dto.getBusinessName());
		b.setBusinessLocation(dto.getBusinessLocation());
		return b;
	}

}
