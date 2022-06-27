package com.nashtech.assignment.ecommerce.service;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.Query;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public interface ProductService {
	
	public List<Products> getAllProducts();
	
	public Products getProductById(int id);
	
	public List<Products> getProductByPriceIncrease();
	
	public Products saveProduct( Products products);
	
	public List<Products> getProductByPriceDecrease();
	
	
	public List<ProductFeature> getListProductByCatogery(String name);
	

	

}
