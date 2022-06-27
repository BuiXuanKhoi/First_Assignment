package com.nashtech.assignment.ecommerce.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@PostMapping("/customers")
	public Customers registerCustomer(@RequestBody Customers customers) {
		customers.setCustomerId(0);
		return this.customerService.registerNewCustomers(customers);
	}
	
	@PutMapping("/customers")
	public Customers editCustomerInfo(@RequestBody Customers customers) {
		return this.customerService.editCustomerInfo(customers);
	}
	
	
	

}
