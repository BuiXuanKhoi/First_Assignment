package com.nashtech.assignment.ecommerce.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;


@Repository
public interface ProductFeedbackRepository extends JpaRepository<ProductFeedback, Integer> {
	
	

}
