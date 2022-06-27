package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nashtech.assignment.ecommerce.data.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	
	@Query(value = "select * from order_detail o "
			+ "inner join products p on o.product_id = p.product_id "
			+ "where p.product_name = :name")
	public OrderItem getOrderItemByProductName(String name);
	
	
	@Query(value = "update order_detail set order_detail = :orderItem where order_detail.product_id = :id")
	public OrderItem updateOrderItem(int id, OrderItem orderItem);

}
