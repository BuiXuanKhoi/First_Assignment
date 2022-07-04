package com.nashtech.assignment.ecommerce.services.impl;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Any;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	private ModelMapper modelMapper;
	
	
	@Autowired
	public ProductServiceImpl( ProductRepository productRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}
	

	@Override
	public List<ProductRespondDTO> getAllProducts()
	{
		List<Products> list = this.productRepository.findAll();
		if(!list.isEmpty()) 
		{
			List<ProductRespondDTO> listDTO = new ArrayList<ProductRespondDTO>();
			list.forEach(product -> listDTO.add(modelMapper.map(product, ProductRespondDTO.class)));
			return listDTO;
		}
		
		throw new ResourceNotFoundException("Cannot find any products in storage");
	}
	
	@Override
	public List<ProductFeature> getListProductByCatogery(String name, int pageNumber, int pageSize) 
	{
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<Optional<ProductFeature>> list = this.productRepository.getListProductByCatogery(name,pageable);
		List<ProductFeature> listFeatures = new ArrayList<ProductFeature>();
		
		if(!list.isEmpty())
		{	
			for(int i =0; i < list.size();i++)
			{
				listFeatures.add(list.get(i).get());
			}
			
			return listFeatures;
		}
		throw new ResourceNotFoundException("Cannot found any products belong to list " + name);
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
	public List<ProductFeature> getProductByPriceIncrease(String catogeryName)
	{
		List<ProductFeature> listOfProducts =  this.productRepository.getProductByPriceIncrease(catogeryName);

		return listOfProducts;
	}

	@Override
	public ProductRespondDTO saveProduct(ProductRequestDTO productRequestDTO) {
		Products products = modelMapper.map(productRequestDTO, Products.class);
		this.productRepository.save(products);
		
		return modelMapper.map(products, ProductRespondDTO.class);
	}

	@Override
	public List<ProductFeature> getProductByPriceDecrease(String catogeryName) {
		return this.productRepository.getProductByPriceDecrease(catogeryName);
	}


	@Override
	public ProductRespondDTO addNewProduct(ProductRequestDTO productRequest) {
		Products products = modelMapper.map(productRequest, Products.class);
		Products savedProducts = this.productRepository.save(products);
				
		return modelMapper.map(savedProducts, ProductRespondDTO.class);
	}




	


	
	

}
