package com.nashtech.assignment.ecommerce.service;

import java.util.List;

import com.nashtech.assignment.ecommerce.DTO.request.FeedbackRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;

public interface ProductFeedbackService {
	
	public ProductFeedback saveFeedback(FeedbackRequestDTO feedbackRequestDTO, int productId);
	
	public ProductFeedback updateFeedback(FeedbackRequestDTO feedbackRequestDTO, int productId);
	
	public List<ProductFeedback> getFeedbackList();
	
	public List<ProductFeedback> getFeedbackByProduct(int productId);
	
	public void deleteFeedbackById(int id);
	
	public List<ProductFeedback> getListFeedbackByUser();

}
