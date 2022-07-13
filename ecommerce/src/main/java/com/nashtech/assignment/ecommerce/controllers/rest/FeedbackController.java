package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.request.FeedbackRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;
import com.nashtech.assignment.ecommerce.service.ProductFeedbackService;

@RestController
@RequestMapping("/api/products/feedbacks")
public class FeedbackController {
	
	private ProductFeedbackService productFeedbackService;
	
	@Autowired
	public FeedbackController(ProductFeedbackService productFeedbackService) {
		this.productFeedbackService = productFeedbackService;
	}
	

	
	@GetMapping
	public List<ProductFeedback> getListFeedbackByProduct(@RequestParam(name = "id", defaultValue = "1", required = true ) int productId){
		
		return this.productFeedbackService.getFeedbackByProduct(productId);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public ProductFeedback addFeedback(@RequestBody FeedbackRequestDTO feedbackRequestDTO,
			@RequestParam(name = "id", required = true) int productId) {
		return this.productFeedbackService.saveFeedback(feedbackRequestDTO, productId);
	};
	
	@DeleteMapping
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteFeedback(@RequestParam(name = "feedbackId", required = true) int feedbackId) {
		this.productFeedbackService.deleteFeedbackById(feedbackId);;
		return ResponseEntity.ok("Delete Feedback Success");
	}
	
	@PatchMapping
	@PreAuthorize("hasRole('CUSTOMER') or hasAuthority('ADMIN')")
	public ProductFeedback updateFeedback( @Valid @RequestBody FeedbackRequestDTO feedbackRequestDTO,
			@RequestParam(name = "id", required = true) int productId) {
		return this.productFeedbackService.updateFeedback(feedbackRequestDTO, productId);
	}
	

	
	

}
