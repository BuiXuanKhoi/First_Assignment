package com.nashtech.assignment.ecommerce.service;

import com.nashtech.assignment.ecommerce.data.entities.Orders;

public interface OrderService {
	
	public Orders deleteOrders(Orders orders);
	
	public Orders createOrders(Orders orders);
	
	public Orders updateOrders(Orders orders);
	

}
