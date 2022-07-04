package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Cart;
import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.Customers;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<CartItems> findByCustomers(Customers customers);
	
	@Query(value = "select * from cart where cart.customer_id = :id", nativeQuery = true)
	Cart findCartByCustomerId(int id);
	
	@Query(value = "select * from cart where user_id = :id", nativeQuery = true)
	Cart findCartByCustomer(int id);
	
	

}
