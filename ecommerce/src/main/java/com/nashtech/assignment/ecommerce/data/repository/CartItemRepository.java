package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.CartItems;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Products;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Integer> {
	
	List<CartItems> findByCustomers(Customers customers);
	
	@Query(value = "select * from cart_detail c "
			+ "inner join products p on c.product_id = p.product_id  ", nativeQuery = true)
	CartItems findByCartAndProductName(int cart_id, String product_name);
	

}
