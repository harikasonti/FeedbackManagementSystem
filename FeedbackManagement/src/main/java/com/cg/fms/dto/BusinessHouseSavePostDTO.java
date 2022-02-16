package com.cg.fms.dto;

import javax.validation.constraints.NotNull;

public class BusinessHouseSavePostDTO {
	@NotNull(message="businessName should not be Empty")
	private String businessName;
	@NotNull(message="businessLocation should not be Empty")
	private String businessLocation;
	public BusinessHouseSavePostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessLocation() {
		return businessLocation;
	}
	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}
	
	

}
