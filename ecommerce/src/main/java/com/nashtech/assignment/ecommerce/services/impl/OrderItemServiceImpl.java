package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.OrderItem;
import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.OrderItemRepository;
import com.nashtech.assignment.ecommerce.data.repository.OrderRepository;
import com.nashtech.assignment.ecommerce.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	private OrderItemRepository orderItemRepository;
	
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderItemServiceImpl( OrderItemRepository orderItemRepository, OrderRepository orderRepository) {
		this.orderItemRepository = orderItemRepository;
		this.orderRepository = orderRepository;
		
	}



	@Override
	public void addNewOrderItem(CartItems cartItems, int orderId) {
		int quantity = cartItems.getCartItemQuantity();
		int price = cartItems.getCartItemTotalPrice();
		Products products = cartItems.getProduct();
		Orders orders = this.orderRepository.findById(orderId).get();
		
		OrderItem orderItem = new OrderItem(orders, products, quantity, price);
		 this.orderItemRepository.save(orderItem);
		
	}



	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		this.orderItemRepository.delete(orderItem);
		
	}

}
