package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.data.entities.OrderItem;

public interface OrderItemService {
	
	public List<OrderItem> getListOrderItem();
	
	public OrderItem getOrderItemByProductName(String name);
	
	public OrderItem addNewOrderItem(OrderItem orderItem);
	
	public OrderItem uploadOrderItem(OrderItem orderItem);
	
	public void deleteOrderItem(OrderItem orderItem);

}
