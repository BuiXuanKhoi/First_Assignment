package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.repository.CustomerRepository;
import com.nashtech.assignment.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;

	public CustomerServiceImpl( @Autowired CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customers registerNewCustomers(Customers customers) {
		return this.customerRepository.save(customers);
	}

	@Override
	public Customers updateCustomer(Customers customers) {
		return this.customerRepository.save(customers);
	}

	@Override
	public List<Customers> getListCustomers() {
		return this.customerRepository.findAll();
	}
	
	
	
	
	

}
