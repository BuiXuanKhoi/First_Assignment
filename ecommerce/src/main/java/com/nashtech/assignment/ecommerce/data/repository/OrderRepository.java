package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.OrderItem;
import com.nashtech.assignment.ecommerce.data.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>
{
	@Query(value = "select * from orders where user_id = :userId", nativeQuery = true)
	public List<Orders> getListOrderByOwner(int userId);
	
	
	


}
