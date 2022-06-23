package com.nashtech.assignment.ecommerce.service;

import com.nashtech.assignment.ecommerce.data.entities.Orders;

public interface OrderService {
	
	public Orders findOrderByOwnerPhoneNumber(int phone);

}
