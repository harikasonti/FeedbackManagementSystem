package com.cg.fms.web;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.BusinessHouseDTO;
import com.cg.fms.dto.BusinessHouseSavePostDTO;
import com.cg.fms.entity.BusinessHouse;
import com.cg.fms.entity.Feedback;
import com.cg.fms.entity.Product;
import com.cg.fms.service.IBusinessHouseService;

@RestController
@RequestMapping("/app")
public class BusinessHouseWebController {
	@Autowired
	IBusinessHouseService service;
	
	@PostMapping("/businessinsert")
	public boolean addBusinessHouse(@RequestBody BusinessHouse businesshouse){
		service.addBuisnessHouse(businesshouse);
		return true;
	}
	
	@DeleteMapping("/business/{businessId}")
	public boolean removeBusinessHouse(@PathVariable int businessId) {
		 return service.removeBuisnessHouse(businessId);
	}
	
	
	@GetMapping("/business")
	public List<BusinessHouse> getAllBusinessHouse(){
		return service.getAllBusinessHouse();
		
	}
	
	@PostMapping("/businessdto")
	public ResponseEntity<BusinessHouseDTO> saveBusiness(@RequestBody @Valid BusinessHouseSavePostDTO b){
		BusinessHouseDTO dto=service.saveBusiness(b);
		return new ResponseEntity<BusinessHouseDTO>(dto,HttpStatus.OK);
		
	}
	@GetMapping("/businessbyname/{businessName}")
	public List<BusinessHouse> getByName(@PathVariable String businessName){
		return service.getByName(businessName);
		
	}
	@GetMapping("/business/{businessLocation}")
	public List<BusinessHouse> getBusinessHouseOnLocation(@PathVariable String businessLocation)
	{ 
		return service.getBusinessHouseOnLocation(businessLocation);
		
	}
	
	@PutMapping("/businessrating/{businessId}")
	@Transactional
	public boolean calculateAndUpdateRating(@PathVariable int businessId)
	{ 
		return service.calculateAndUpdateRating(businessId);
		
	}
	@GetMapping("/business/avgrating")// products/price?sort=acs
	public List<BusinessHouse> sortBusinessHouseBasedOnRating(){
		return service.sortBusinessHouseBasedOnAvgRating();
	}
	
	
}
