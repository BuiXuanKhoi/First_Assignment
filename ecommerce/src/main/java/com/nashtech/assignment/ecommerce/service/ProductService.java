package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.data.entities.Products;

public interface ProductService {
	
	public List<Products> getAllProducts();
	

	public Products getProductById(int id);

}
