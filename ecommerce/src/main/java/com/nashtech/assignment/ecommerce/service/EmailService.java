package com.nashtech.assignment.ecommerce.service;

import org.springframework.http.ResponseEntity;

import com.nashtech.assignment.ecommerce.data.entities.EmailDetail;

public interface EmailService {
	
	public ResponseEntity<?> sendVertiCode(EmailDetail emailDetail);

}
