package com.nashtech.assignment.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(@Autowired ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Products> getAllProducts() {
	
		return this.productRepository.findAll();
	}

	@Override
	public Products getProductById(int id) {
		return this.productRepository.findProductsById(id);
	}

	@Override
	public ArrayList<Products> getListOfProductIncreaseInPrice()
	{
		int min;
		ArrayList<Products> listOfProducts = new ArrayList<>(this.productRepository.findAll());
		int sizeOfList = listOfProducts.size();
		for(int i =0; i<sizeOfList;i++)
		{
			min = i;
			for(int j = i +1; j < sizeOfList; j++ ) 
			{
				if(listOfProducts.get(min).getProductPrice() > listOfProducts.get(j).getProductPrice())
				{
					Collections.swap(listOfProducts, min, j);
				}
			}
		}
		return listOfProducts;
	}

	@Override
	public Products saveProduct(Products products) {
		
		return this.productRepository.save(products);
	}


	
	

}
