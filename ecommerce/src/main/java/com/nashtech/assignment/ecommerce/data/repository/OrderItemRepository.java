package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nashtech.assignment.ecommerce.data.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	
	@Query(value = "select * from order_detail o "
			+ "inner join products p on o.product_id = p.product_id "
			+ "where p.product_name = :name", nativeQuery = true)
	public OrderItem getOrderItemByProductName(String name);
	
	@Query(value = "select * from order_detail where order_id = :id", nativeQuery = true)
	public List<OrderItem> getOrderItemsByOrder(int id);
	
	


}
