package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.DTO.request.OrderRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.Orders;

public interface OrderService {
	
	
	public Orders createOrders(OrderRequestDTO orderRequestDTO);
	
	public List<Orders> getListOrderByOwner();
	
	public void deleteOrder(int orderId);
	
	

}
