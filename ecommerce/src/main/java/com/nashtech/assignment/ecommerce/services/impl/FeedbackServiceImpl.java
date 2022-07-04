package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;
import com.nashtech.assignment.ecommerce.data.repository.ProductFeedbackRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.service.ProductFeedbackService;


@Service
public class FeedbackServiceImpl implements ProductFeedbackService {
	
	private ProductFeedbackRepository productFeedbackRepository;
	private UserLocal userLocal;
	private UserRepository userRepository;
	
	@Autowired
	public FeedbackServiceImpl( ProductFeedbackRepository productFeedbackRepository, UserLocal userLocal, UserRepository userRepository) {
		this.productFeedbackRepository = productFeedbackRepository;
		this.userLocal = userLocal;
		this.userRepository = userRepository;
	}

	@Override
	public ProductFeedback saveFeedback(ProductFeedback productFeedback) {
		
		return this.productFeedbackRepository.save(productFeedback);
	}

	@Override
	public List<ProductFeedback> getFeedbackList() {
		return this.productFeedbackRepository.findAll();
	}

	@Override
	public String deleteById(int id) {
		Optional<ProductFeedback> feedbackOptional = this.productFeedbackRepository.findById(id);
		if(feedbackOptional.isPresent()) 
		{
			this.productFeedbackRepository.deleteById(id);
			return "Delete Success";
		}
		throw new ResourceNotFoundException("Cannot find that feed back");
		
	}

	@Override
	public List<ProductFeedback> getListFeedbackByUser() {
		String userName = userLocal.getLocalUser();
		int userId = this.userRepository.getIdByName(userName);
		return this.productFeedbackRepository.getListFeedbackByUser(userId);
	}
	
	

}
