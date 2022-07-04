package com.nashtech.assignment.ecommerce.service;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.Query;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public interface ProductService {
	
	public List<ProductRespondDTO> getAllProducts();
	
	public ProductRespondDTO getProductById(int id);
	
	public List<ProductFeature> getProductByPriceIncrease(String catogeryName);
	
	public ProductRespondDTO saveProduct( ProductRequestDTO productRequestDTO);
	
	public List<ProductFeature> getProductByPriceDecrease(String catogeryName);
	
	public ProductRespondDTO addNewProduct(ProductRequestDTO productRequest);
	
	
	public List<ProductFeature> getListProductByCatogery(String name, int pageNumber, int pageSize);
	
	

	

}
