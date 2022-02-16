package com.cg.fms.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.BusinessHouse;
import com.cg.fms.entity.Feedback;


@Repository
public class CustomBusinessHouseRepositoryImpl implements CustomBusinessHouseRepository{
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<BusinessHouse> getByName(String businessName) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		String queryString="from BusinessHouse b where b.businessName=:businessName";
		Query<BusinessHouse> query=session.createQuery(queryString);
		query.setString("businessName", businessName);
		
		List<BusinessHouse> list=query.getResultList();
		if(list!=null) {
			return list;
		}
		else {
			throw new javax.persistence.NoResultException("Business Name Records Not In The DB");			
		}
	}
	
	@Override
	public List<BusinessHouse> getBusinessHouseByLocation(String businessLocation) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		String queryString="from BusinessHouse b where b.businessLocation=:businessLocation";
		Query<BusinessHouse> query=session.createQuery(queryString);
		query.setString("businessLocation", businessLocation);
		
		List<BusinessHouse> list=query.getResultList();
		if(list!=null) {
			return list;
		}
		else {
			throw new javax.persistence.NoResultException("Business Location Records Not In The DB");			
		}
	}

	@Override
	public List<BusinessHouse> getBusinessHouseById(int businessId) {
		Session session=entityManager.unwrap(Session.class);
		String queryString="from BusinessHouse b where b.businessId=:businessId";
		Query<BusinessHouse> query=session.createQuery(queryString);
		query.setInteger("businessId", businessId);
		
		List<BusinessHouse> list=query.getResultList();
		
		if(list!=null) {
			return list;
		}
		else {
			throw new javax.persistence.NoResultException("Business Location Records Not In The DB");			
		}
	}


	@Override
	public boolean updateRatingById(double avgRating, int businessId) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		String queryString="UPDATE BusinessHouse b SET b.avgRating=:avgRating where b.businessId=:businessId";
		Query<BusinessHouse> query=session.createQuery(queryString);
		query.setParameter("avgRating", avgRating);
		query.setParameter("businessId", businessId);
		
		
		int updatedrows=query.executeUpdate();
		if(updatedrows==1) {
			return true;		
		}
		else {
			throw new javax.persistence.NoResultException("Business Location Records Not In The DB");			
		}
	}

	
	

}
