package com.nashtech.assignment.ecommerce.service;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.Any;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.ProductUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;

public interface ProductService {
	
	public Page<ProductRespondDTO> getAllProducts(String mode, int page, int size);
	
	public ProductRespondDTO getProductById(int id);
	
	public ResponseEntity<?> deleteProduct();
	
	
	public ProductRespondDTO updateProduct( ProductUpdateDTO productUpdateDTO);
	
	
	public ProductRespondDTO addNewProduct(ProductRequestDTO productRequest, String catogeryName);
	
	
	public Page<ProductRespondDTO> getListProductByCatogery(int productCatogeryId, String mode, int page, int size);
	
	public List<ProductCatogery> getAllCatogeries();
	
	

	

}
