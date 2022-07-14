package com.nashtech.assignment.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.respond.OrderItemRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.OrderItem;
import com.nashtech.assignment.ecommerce.data.entities.Orders;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.repository.OrderItemRepository;
import com.nashtech.assignment.ecommerce.data.repository.OrderRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	private OrderItemRepository orderItemRepository;
	
	private OrderRepository orderRepository;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public OrderItemServiceImpl( OrderItemRepository orderItemRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
		this.orderItemRepository = orderItemRepository;
		this.orderRepository = orderRepository;
		this.modelMapper = modelMapper;		
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



	@Override
	public List<OrderItemRespondDTO> getListOrderItemById(int id) {
		List<OrderItem> listOrderItems = this.orderItemRepository.getOrderItemsByOrder(id);
		if(!listOrderItems.isEmpty()) 
		{
			List<OrderItemRespondDTO> listOrderItemRespondDTOs = new ArrayList<OrderItemRespondDTO>();
			listOrderItems.forEach(item->{
				OrderItemRespondDTO orderItemRespondDTO = modelMapper.map(item, OrderItemRespondDTO.class);
				orderItemRespondDTO.setOrderId(id);
				orderItemRespondDTO.setProductName(item.getProducts().getProductName());
				listOrderItemRespondDTOs.add(orderItemRespondDTO);
			});
			return listOrderItemRespondDTOs;			
		}
		throw new ResourceNotFoundException("Orders Not Found With ID " + id);
	}

}
