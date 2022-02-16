package com.cg.fms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.customsort.ByPrice;
import com.cg.fms.entity.Product;
import com.cg.fms.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	IProductRepository repository;
	
	@Autowired
	ByPrice sortByPriceHigherToLower;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return repository.save(product);
	}

	@Override
	public boolean removeProduct(int productId) {
		// TODO Auto-generated method stub
		repository.deleteById(productId);
		return true;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> list=(List<Product>) repository.findAll();
		return list;
	}

	@Override
	public List<Product> getproductInRange(int range1, int range2) {
		// TODO Auto-generated method stub
		
		return repository.getproductInRange(range1, range2);
	}
	
	@Override
	public List<Product> getproductBasedOnpriceSort() {
	//if sorting type is = acs else change is to o2 to o1 
	
		List<Product> list=getAllProducts();
		Collections.sort(list, sortByPriceHigherToLower);
		return list;
		
	}

}
