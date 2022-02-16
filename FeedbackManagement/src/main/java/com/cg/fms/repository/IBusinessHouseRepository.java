package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.BusinessHouse;

@Repository
public interface IBusinessHouseRepository extends CrudRepository<BusinessHouse, Integer>,CustomBusinessHouseRepository{
	

}
