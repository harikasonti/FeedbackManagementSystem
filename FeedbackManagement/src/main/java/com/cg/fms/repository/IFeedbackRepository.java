package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.Feedback;

@Repository
public interface IFeedbackRepository extends CrudRepository<Feedback, Integer>,CustomFeedbackRepository{

}
