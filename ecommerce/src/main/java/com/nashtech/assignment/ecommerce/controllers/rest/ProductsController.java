package com.nashtech.assignment.ecommerce.controllers.rest;

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

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/products")
public class ProductsController 
{
	private ProductService productService;
	
	
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/talk")
	public String Hello() {
		return "This API worked";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET )
	public Products findProductById(@PathVariable("id") int id) {
		 return this.productService.getProductById(id);
	}
	
	
	@GetMapping("/all")
	public List<Products> getAllProducts() {
		return this.productService.getAllProducts();
	}
}
