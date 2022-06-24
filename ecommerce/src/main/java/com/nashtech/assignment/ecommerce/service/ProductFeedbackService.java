package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;

public interface ProductFeedbackService {
	
	public ProductFeedback saveFeedback(ProductFeedback productFeedback);
	
	public List<ProductFeedback> getFeedbackList();

}
