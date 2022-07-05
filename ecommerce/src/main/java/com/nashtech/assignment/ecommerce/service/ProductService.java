package com.nashtech.assignment.ecommerce.service;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.Query;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public interface ProductService {
	
	public List<ProductRespondDTO> getAllProducts();
	
	public ProductRespondDTO getProductById(int id);
	
	
	public ProductRespondDTO saveProduct( ProductRequestDTO productRequestDTO);
	
	
	public ProductRespondDTO addNewProduct(ProductRequestDTO productRequest);
	
	
	public ProductCatogery getListProductByCatogery(String name, String mode);
	
	

	

}
