package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/customers")
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	
	@PutMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public Customers editCustomerInfo( @Valid @RequestBody Customers customers) {
		return this.customerService.updateCustomer(customers);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('Admin')")
	public List<Customers> getListCustomers(){
		return this.customerService.getListCustomers();
	}
	
	
	

}
