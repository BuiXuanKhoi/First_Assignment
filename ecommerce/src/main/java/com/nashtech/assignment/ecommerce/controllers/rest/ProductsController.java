package com.nashtech.assignment.ecommerce.controllers.rest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductsController 
{
	private ProductService productService;
	
	
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET )
	public Products findProductByName(@PathVariable("name") String name) {
		 return this.productService.getProductByName(name);
	}
	

	
	
	@GetMapping("/all")
	public List<Products> getAllProducts() {
		return this.productService.getAllProducts();
	}
	
	@GetMapping("/price/increase")
	public ArrayList<Products>getListOfProductIncreaseInPrice(){
		return this.productService.getListOfProductIncreaseInPrice();
	}
}
