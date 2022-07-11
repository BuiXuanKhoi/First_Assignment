package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.data.entities.Customers;

public interface CustomerService {
	
	public Customers registerNewCustomers(Customers customers);
	
	public Customers updateCustomer(Customers customers);
	
	public List<Customers> getListCustomers();

}
