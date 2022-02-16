package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.Product;

@Repository
public interface IProductRepository extends CrudRepository<Product,Integer>,CustomProductRepository{

}
