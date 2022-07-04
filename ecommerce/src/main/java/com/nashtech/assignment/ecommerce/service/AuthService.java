package com.nashtech.assignment.ecommerce.service;

import org.springframework.http.ResponseEntity;

import com.nashtech.assignment.ecommerce.payload.request.LoginRequest;
import com.nashtech.assignment.ecommerce.payload.request.RegisterAdmin;
import com.nashtech.assignment.ecommerce.payload.request.RegisterCustomer;
import com.nashtech.assignment.ecommerce.payload.request.SignupRequest;

public interface AuthService {
	
	public ResponseEntity<?> registerUser(SignupRequest signupRequest);
	
	public ResponseEntity<?> continueRegisterCustomer(RegisterCustomer registerCustomer);
	
	public ResponseEntity<?> loginAccount(LoginRequest loginRequest);
	
	public ResponseEntity<?> continueRegisterAdmin(RegisterAdmin registerAdmin);
}
