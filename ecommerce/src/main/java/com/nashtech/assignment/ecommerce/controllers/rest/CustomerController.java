package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@PostMapping
	public Customers registerCustomer(@RequestBody Customers customers) {
		customers.setCustomerId(0);
		return this.customerService.registerNewCustomers(customers);
	}
	
	@PutMapping
	public Customers editCustomerInfo(@RequestBody Customers customers) {
		return this.customerService.editCustomerInfo(customers);
	}
	
	@GetMapping
	public List<Customers> getListCustomers(){
		return this.customerService.getListCustomers();
	}
	
	
	

}
