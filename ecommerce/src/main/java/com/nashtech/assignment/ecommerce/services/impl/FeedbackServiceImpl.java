package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;
import com.nashtech.assignment.ecommerce.data.repository.ProductFeedbackRepository;
import com.nashtech.assignment.ecommerce.service.ProductFeedbackService;


@Service
public class FeedbackServiceImpl implements ProductFeedbackService {
	
	private ProductFeedbackRepository productFeedbackRepository;
	
	public FeedbackServiceImpl(@Autowired ProductFeedbackRepository productFeedbackRepository) {
		this.productFeedbackRepository = productFeedbackRepository;
	}

	@Override
	public ProductFeedback saveFeedback(ProductFeedback productFeedback) {
		
		return this.productFeedbackRepository.save(productFeedback);
	}

	@Override
	public List<ProductFeedback> getFeedbackList() {
		return this.productFeedbackRepository.findAll();
	}
	
	

}
