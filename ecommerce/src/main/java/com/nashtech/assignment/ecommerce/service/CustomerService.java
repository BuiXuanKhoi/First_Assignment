package com.nashtech.assignment.ecommerce.service;

import com.nashtech.assignment.ecommerce.data.entities.Customers;

public interface CustomerService {
	
	public Customers registerNewCustomers(Customers customers);
	
	public Customers editCustomerInfo(Customers customers);

}
