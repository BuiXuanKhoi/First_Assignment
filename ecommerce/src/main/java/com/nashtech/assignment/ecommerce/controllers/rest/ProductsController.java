package com.nashtech.assignment.ecommerce.controllers.rest;

import java.lang.reflect.Array;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.hibernate.mapping.Any;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.request.ProductRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.ProductUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductCatogery;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.exception.ApiDeniedException;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.jwt.JwtAuthEntryPoint;
import com.nashtech.assignment.ecommerce.service.ProductService;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
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
	public ProductRespondDTO addNewProducts( @Valid @RequestBody ProductRequestDTO productRequest,
			@RequestParam(name = "catogery", required = true, defaultValue = "Tablet") String catogeryName) 
	{
		  return this.productService.addNewProduct(productRequest, catogeryName);
	}
	
	@PatchMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ProductRespondDTO updateProducts( @Valid @RequestBody ProductUpdateDTO productRequestDTO)
	{
		return this.productService.updateProduct(productRequestDTO);
	}
	
	
	@GetMapping("/{id}")
	@PermitAll
	@PreAuthorize("permitAll()")
	public Page<ProductRespondDTO> getListProductByCategory(@PathVariable("id") int id,
			@RequestParam(name = "mode", required = false, defaultValue = "a") String mode,
			@RequestParam(name = "size", required = false, defaultValue = "1") String size,
			@RequestParam(name = "page",required = false, defaultValue = "1") String page
			){
		int sizeConvert = Integer.parseInt(size);
		int pageConvert = Integer.parseInt(page);
		return  this.productService.getListProductByCatogery(id, mode, pageConvert, sizeConvert);
	}
	
	@GetMapping
	@PermitAll
	@PreAuthorize("permitAll()")
	public Page<ProductRespondDTO> getAllProducts(
			@RequestParam(name = "mode", required = false, defaultValue = "asc") String mode,
			@RequestParam(name = "size", required = false, defaultValue = "5") String size,
			@RequestParam(name = "page", required = false, defaultValue = "0") String page)
	{
		int sizeConvert = Integer.parseInt(size);
		int pageConvert = Integer.parseInt(page);
		
		return this.productService.getAllProducts(mode,pageConvert,sizeConvert);
	}
	
	@GetMapping("/catogeries")
	@PermitAll
	@PreAuthorize("permitAll()")
	public List<ProductCatogery> getAllCatogeries(){
		return this.productService.getAllCatogeries();
	}
	
	
	
}
