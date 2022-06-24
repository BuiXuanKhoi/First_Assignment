package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query(value = "select * from products where product_name = :name", nativeQuery = true)
	Products findProductsByName(String name);
	
	@Query(value = "select * from products p "
			+ "inner join product_feedback pf on p.product_id = pf.product_id "
			+ "where feedback_rating = (select max(feedback_rating) from product_feedback)")
	Products getHighestScoreProducts();//Not yet implemented(soon).

	
	
	
	
	
	

	

}
