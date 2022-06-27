package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.OrderItem;
import com.nashtech.assignment.ecommerce.data.repository.OrderItemRepository;
import com.nashtech.assignment.ecommerce.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	private OrderItemRepository orderItemRepository;
	
	

	public OrderItemServiceImpl( @Autowired OrderItemRepository orderItemRepository) {
		super();
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public List<OrderItem> getListOrderItem() {
		return this.orderItemRepository.findAll();
	}

	@Override
	public OrderItem getOrderItemByProductName(String name) {
		return this.orderItemRepository.getOrderItemByProductName(name);
	}

	@Override
	public OrderItem addNewOrderItem(OrderItem orderItem) {
		orderItem.setOrderItemId(0);
		return this.orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem uploadOrderItem(int id, OrderItem orderItem) {
		return this.orderItemRepository.updateOrderItem(id, orderItem);
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		this.orderItemRepository.delete(orderItem);
		
	}

}
