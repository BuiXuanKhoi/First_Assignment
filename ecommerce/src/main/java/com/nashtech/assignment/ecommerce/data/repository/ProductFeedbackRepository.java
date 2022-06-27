package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;


@Repository
public interface ProductFeedbackRepository extends JpaRepository<ProductFeedback, Integer> {
	
	
	@Query(value = "insert into product_feedback values :productFeedback where :producefeedback.product_id ", nativeQuery = true)
	public ProductFeedback saveProductFeedback(ProductFeedback productFeedback);
	
	

}