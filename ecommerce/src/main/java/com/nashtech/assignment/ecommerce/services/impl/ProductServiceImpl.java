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
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductCatogeryRepository;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
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
	public ProductRespondDTO saveProduct(ProductRequestDTO productRequestDTO) {
		Products products = modelMapper.map(productRequestDTO, Products.class);
		this.productRepository.save(products);
		
		return modelMapper.map(products, ProductRespondDTO.class);
	}


	@Override
	public ProductRespondDTO addNewProduct(ProductRequestDTO productRequest) {
		Products products = modelMapper.map(productRequest, Products.class);
		Products savedProducts = this.productRepository.save(products);
				
		return modelMapper.map(savedProducts, ProductRespondDTO.class);
	}


	@Override
	public ProductCatogery getListProductByCatogery(String name, String mode)
	{
		Optional<ProductCatogery> catogeryOptional = this.productCatogeryRepository.getCatogeryByName(name);
		if(catogeryOptional.isPresent()) 
		{
			ProductCatogery productCatogery = catogeryOptional.get();
			if(mode.equals("")) 
			{
				return productCatogery;
			}
			if(mode.equals("decrease")) 
			{
				productCatogery.setListProducts(this.productRepository.getProductByPriceDecrease(name));
				return productCatogery;
			}
			if(mode.equals("increase"))
			{
				productCatogery.setListProducts(this.productRepository.getProductByPriceIncrease(name));
				return productCatogery;
			}
		}
		
		throw new ResourceNotFoundException("Catogery Not Found !");
	}





	


	
	

}
