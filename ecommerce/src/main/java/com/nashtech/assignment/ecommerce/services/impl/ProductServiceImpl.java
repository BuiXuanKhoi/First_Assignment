package com.nashtech.assignment.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
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
	public List<Products> getProductByPriceIncrease()
	{
		return this.productRepository.getProductByPriceIncrease();
	}

	@Override
	public Products saveProduct(Products products) {
		
		return this.productRepository.save(products);
	}

	@Override
	public List<Products> getProductByPriceDecrease() {
		return this.productRepository.getProductByPriceDecrease();
	}

	@Override
	public List<ProductFeature> getListProductByCatogery(String name) {
		return this.productRepository.getListProductByCatogery(name);
	}


	
	

}
