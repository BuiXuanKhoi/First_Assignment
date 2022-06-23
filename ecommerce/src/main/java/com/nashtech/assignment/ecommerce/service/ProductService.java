package com.nashtech.assignment.ecommerce.service;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

import com.nashtech.assignment.ecommerce.data.entities.Products;

public interface ProductService {
	
	public List<Products> getAllProducts();
	

	public Products getProductByName(String name);
	
	public ArrayList<Products> getListOfProductIncreaseInPrice();

}
