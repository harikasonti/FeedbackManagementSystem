package com.cg.fms.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.BusinessHouse;
import com.cg.fms.entity.Feedback;
import com.cg.fms.entity.Product;

@Repository
public class CustomFeedbackRepositoryImpl implements CustomFeedbackRepository{
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Feedback> getFeedbackById(int businessId) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		String queryString="from BusinessHouse b where b.businessId=:businessId";
		Query<BusinessHouse> query=session.createQuery(queryString);
		query.setInteger("businessId", businessId);
		
		List<BusinessHouse> list=query.getResultList();
		if(list!=null) {
			return list.get(0).getFeedback();
		}
		else {
			throw new javax.persistence.NoResultException("Business Location Records Not In The DB");			
		}
		
	}

	
	
	

}
