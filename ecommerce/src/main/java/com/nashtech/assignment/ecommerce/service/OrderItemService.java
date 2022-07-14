package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.DTO.respond.OrderItemRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.OrderItem;

public interface OrderItemService {
	

	
	public void addNewOrderItem(CartItems cartItems, int orderId);
		
	public void deleteOrderItem(OrderItem orderItem);
	
	public List<OrderItemRespondDTO> getListOrderItemById(int id);
}
