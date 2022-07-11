package com.nashtech.assignment.ecommerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;


@Repository
public interface ProductFeedbackRepository extends JpaRepository<ProductFeedback, Integer> {
	
	

	
	@Query(value = "select * from product_feedback where user_id = :userId ", nativeQuery = true)
	public List<ProductFeedback> getListFeedbackByUser(int userId);
	
	
	@Query(value = "select * from product_feedback where user_id = :userId and product_id = :productId", nativeQuery = true)
	public ProductFeedback getFeedbackByUserAndProduct(int productId, int userId);
	
	@Query(value = "select * from product_feedback where product_id = :productId", nativeQuery = true)
	public List<ProductFeedback> getListFeedbackByProduct(int productId);
	

}
