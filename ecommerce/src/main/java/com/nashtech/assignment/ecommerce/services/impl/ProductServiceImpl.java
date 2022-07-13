package com.nashtech.assignment.ecommerce.services.impl;

import java.security.KeyStore.PrivateKeyEntry;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.hibernate.mapping.Any;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.ProductUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductCatogeryRepository;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.jwt.JwtAuthEntryPoint;
import com.nashtech.assignment.ecommerce.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
		
	private ModelMapper modelMapper;
	
	private ProductCatogeryRepository productCatogeryRepository;
	


	
	
	
	@Autowired
	public ProductServiceImpl( ProductRepository productRepository, ModelMapper modelMapper, ProductCatogeryRepository productCatogeryRepository) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
		this.productCatogeryRepository = productCatogeryRepository;
	}
	

	@Override
	public Page<ProductRespondDTO> getAllProducts(String mode, int page, int size)
	{

		Pageable pageable = createPage(mode, page, size);
		Page<Products> pageProducts = this.productRepository.getPageProducts(pageable);
		if(pageProducts.hasContent()) 
		{
			Page<ProductRespondDTO> pageProductDTO = pageProducts.map(this::convertToProductDTO);
			return pageProductDTO;
		}
		
		throw new ResourceNotFoundException("Cannot get Page at this size");
	}
	
	
	
	@Override
	public Page<ProductRespondDTO> getListProductByCatogery(int productCatogeryId, String mode, int page, int size)
	{		
		Pageable pageable = createPage(mode,page,size);
		Page<Products> pageProducts = this.productRepository.getPageProductByCatogery(productCatogeryId, pageable);

		if( pageProducts != null) 
		{
			Page<ProductRespondDTO> pageProductDTO = pageProducts.map(this::convertToProductDTO);
			return pageProductDTO;
		} 
		
		throw new ResourceNotFoundException("Catogery Not Found !");
	}
	
	

	@Override
	public ProductRespondDTO getProductById(int id)
	{
		Optional<Products> productOptional = this.productRepository.findById(id);
		
		if(productOptional.isPresent()) 
		{
			Products products = productOptional.get();
			return modelMapper.map(products, ProductRespondDTO.class);
		}
		
		throw new ResourceNotFoundException("Product Not Found With ID "+ id);
	}



	@Override
	public ProductRespondDTO updateProduct(ProductUpdateDTO productUpdateDTO)
	{
		Optional<Products> productOptinal = productRepository.findById(productUpdateDTO.getProductId());
			if(productOptinal.isPresent()) 
			{
				Products utilProducts = productOptinal.get();
				ProductCatogery productCatogery = utilProducts.getProductCatogery();
				
				Products products = modelMapper.map(productUpdateDTO, Products.class);
				products.setProductCatogery(productCatogery);
				products.setProductUpdateDay(new Date());	
				
				Products savedProduct = this.productRepository.save(products);
							
				return modelMapper.map(savedProduct, ProductRespondDTO.class);	
			}	
			
			throw new ResourceNotFoundException("Product Not Found With ID : " + productUpdateDTO.getProductId());
	}


	@Override
	public ProductRespondDTO addNewProduct(ProductRequestDTO productRequest, String catogeryName) {
		Products products = modelMapper.map(productRequest, Products.class);
		
		ProductCatogery productCatogery = productCatogeryRepository.getCatogeryByName(catogeryName);
		products.setProductCatogery(productCatogery);
		products.setProductCreateDay(new Date());
		
		Products savedProducts = this.productRepository.save(products);				
		return modelMapper.map(savedProducts, ProductRespondDTO.class);
	}



	
	private ProductRespondDTO convertToProductDTO(Products products) {
		return modelMapper.map(products, ProductRespondDTO.class);
	}
	
	
	public Pageable createPage(String mode, int page, int size) 
	{
		Sort sort = Sort.by("product_price").ascending();
		
		if(mode.equals("d")) 
		{
			sort = Sort.by("product_price").descending();
		}
		
		return PageRequest.of(page, size, sort);
		
	}


	@Override
	public ResponseEntity<?> deleteProduct() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductCatogery> getAllCatogeries() {
		return this.productCatogeryRepository.findAll();
	}





	


	
	

}
