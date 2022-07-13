package com.nashtech.assignment.ecommerce.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.DTO.request.FeedbackRequestDTO;
import com.nashtech.assignment.ecommerce.data.entities.ProductFeedback;
import com.nashtech.assignment.ecommerce.data.entities.Products;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.ProductFeedbackRepository;
import com.nashtech.assignment.ecommerce.data.repository.ProductRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.service.ProductFeedbackService;


@Service
public class FeedbackServiceImpl implements ProductFeedbackService {
	
	private ProductFeedbackRepository productFeedbackRepository;
	private UserLocal userLocal;
	private UserRepository userRepository;
	private ModelMapper modelMapper;
	private ProductRepository productRepository;
	
	@Autowired
	public FeedbackServiceImpl( ProductFeedbackRepository productFeedbackRepository, UserLocal userLocal, UserRepository userRepository, ModelMapper modelMapper
			, ProductRepository productRepository) {
		this.productFeedbackRepository = productFeedbackRepository;
		this.userLocal = userLocal;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.productRepository = productRepository;
	}



	@Override
	public List<ProductFeedback> getFeedbackList() {
		return this.productFeedbackRepository.findAll();
	}



	@Override
	public List<ProductFeedback> getListFeedbackByUser() {
		String userName = userLocal.getLocalUser();
		int userId = this.userRepository.getIdByName(userName);
		return this.productFeedbackRepository.getListFeedbackByUser(userId);
	}



	@Override
	public ProductFeedback saveFeedback(FeedbackRequestDTO feedbackRequestDTO, int productId) 
	{
		ProductFeedback productFeedback = modelMapper.map(feedbackRequestDTO, ProductFeedback.class);
		String userName = userLocal.getLocalUser();
		Users userLocal = this.userRepository.findByUserName(userName).get();
		Optional<Products> productOptional = this.productRepository.findById(productId);
		if(productOptional.isPresent()) 
		{
			Products products = productOptional.get();
			productFeedback.setUsers(userLocal);
			productFeedback.setProduct(products);
			productFeedback.setCommentDay(new Date());
			
			return this.productFeedbackRepository.save(productFeedback);
		}
		throw new ResourceNotFoundException("Product Not Found With ID : " + productId);
	}



	@Override
	public ProductFeedback updateFeedback(FeedbackRequestDTO feedbackRequestDTO, int productId) {
		ProductFeedback productFeedback = modelMapper.map(feedbackRequestDTO, ProductFeedback.class);
		String userName = userLocal.getLocalUser();
		Users users = this.userRepository.findByUserName(userName).get();
		Optional<Products> productOptional = this.productRepository.findById(productId);
		
		if(productOptional.isPresent()) {
			int updateId = this.productFeedbackRepository.getFeedbackByUserAndProduct(productId, users.getUserId()).getFeedbackId();
			productFeedback.setUsers(users);
			productFeedback.setFeedbackId(updateId);
			productFeedback.setProduct(productOptional.get());
			productFeedback.setUpdateDay(new Date());
			return this.productFeedbackRepository.save(productFeedback);
		}
		throw new ResourceNotFoundException("Product Not Found With ID : " + productId);
	}



	@Override
	public List<ProductFeedback> getFeedbackByProduct(int productId) {
		Optional<Products> productOptional = this.productRepository.findById(productId);
		if(productOptional.isPresent()) {
			return this.productFeedbackRepository.getListFeedbackByProduct(productId);
		}
		throw new ResourceNotFoundException("Product Not Found With ID : " + productId);
	}



	@Override
	public void deleteFeedbackById(int id) {
		this.productFeedbackRepository.deleteById(id);
	}
	
	

}
