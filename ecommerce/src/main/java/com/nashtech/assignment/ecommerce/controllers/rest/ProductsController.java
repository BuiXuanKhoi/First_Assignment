package com.nashtech.assignment.ecommerce.controllers.rest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.respond.ProductRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeature;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
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
	public Products addNewProduct(@Validated @RequestBody Products products) 
	{
		products.setProductId(0);
		return this.productService.saveProduct(products);
	}
	
	@PutMapping
	public Products updateProducts(@Validated @RequestBody Products products)
	{
		return this.productService.saveProduct(products);
	}
	
	@GetMapping("/price/decrease")
	public List<Products> getListProductsByPriceDecrease(){
		return this.productService.getProductByPriceDecrease();
	}
	
	/*@GetMapping("/{name}")
	public List<Optional<ProductFeature>> getListProductByCategory(@PathVariable("name") String name){
		List<Optional<ProductFeature>> list =  this.productService.getListProductByCatogery(name);
		
		return list;
	}*/
	
	
	@GetMapping
	public List<ProductRespondDTO> getAllProducts()
	{
		return this.productService.getAllProducts();
	}
	
	@GetMapping("/price/increase")
	public List<ProductRespondDTO>getListOfProductIncreaseInPrice()
	{
		return this.productService.getProductByPriceIncrease();
	}
}
