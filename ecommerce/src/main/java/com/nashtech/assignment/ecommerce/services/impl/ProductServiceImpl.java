package com.nashtech.assignment.ecommerce.services.impl;

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
		return this.productRepository.getById(id);
	}
	
	

}
