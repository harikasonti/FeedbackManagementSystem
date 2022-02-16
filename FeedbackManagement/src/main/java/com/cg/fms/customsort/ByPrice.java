package com.cg.fms.customsort;
import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.cg.fms.entity.Product;
@Component
public class ByPrice implements Comparator<Product> {

	public int compare(Product o1, Product o2) {
		return o1.getProductPrice()-o2.getProductPrice();
	}
}