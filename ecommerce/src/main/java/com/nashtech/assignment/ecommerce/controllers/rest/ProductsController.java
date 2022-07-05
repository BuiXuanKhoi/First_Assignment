package com.nashtech.assignment.ecommerce.controllers.rest;

import java.lang.reflect.Array;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.exception.ApiDeniedException;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductsController 
{
	private ProductService productService;
	
	
	
	@Autowired
	public ProductsController(ProductService productService)
	{
		this.productService = productService;
	}
	

	
	
	@PostMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ProductRespondDTO addNewProducts(@Valid @RequestBody ProductRequestDTO productRequest) 
	{
		try
		{
			return this.productService.addNewProduct(productRequest);
		} catch (Exception accessDeniedException) 
		{
			throw new ApiDeniedException("Only Customer can add product");
		}
		
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ProductRespondDTO updateProducts(@Validated @RequestBody ProductRequestDTO productRequestDTO)
	{
		return this.productService.saveProduct(productRequestDTO);
	}
	
	
	@GetMapping("/{name}/{mode}")
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public ProductCatogery getListProductByCategory(@PathVariable("name") String name, @PathVariable("mode") String mode){
		return  this.productService.getListProductByCatogery(name, mode);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public List<ProductRespondDTO> getAllProducts()
	{
		return this.productService.getAllProducts();
	}
	
}
