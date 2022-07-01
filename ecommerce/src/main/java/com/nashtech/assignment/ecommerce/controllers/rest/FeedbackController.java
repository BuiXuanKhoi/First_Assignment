package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;
import com.nashtech.assignment.ecommerce.service.ProductFeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	private ProductFeedbackService productFeedbackService;
	
	@Autowired
	public FeedbackController(ProductFeedbackService productFeedbackService) {
		this.productFeedbackService = productFeedbackService;
	}
	
	@GetMapping
	public List<ProductFeedback> getFeedbackList() {
		return this.productFeedbackService.getFeedbackList();
	}
	
	@PostMapping
	public ProductFeedback addFeedback(@RequestBody ProductFeedback productFeedback) {
		return this.productFeedbackService.saveFeedback(productFeedback);
	};
	
	

}
