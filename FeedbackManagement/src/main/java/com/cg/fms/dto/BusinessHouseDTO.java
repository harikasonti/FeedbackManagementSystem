package com.cg.fms.dto;

public class BusinessHouseDTO {
	private String businessName;
	private String businessCategory;
	private String businessLocation;
	private double avgRating;
	private int CommunicationId;
	public int getCommunicationId() {
		return CommunicationId;
	}
	public void setCommunicationId(int communicationId) {
		CommunicationId = communicationId;
	}
	public BusinessHouseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getBusinessLocation() {
		return businessLocation;
	}
	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double d) {
		this.avgRating = d;
	}
	
	

}
