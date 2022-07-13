package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Roles;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.CustomerRepository;
import com.nashtech.assignment.ecommerce.data.repository.RoleRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.payload.request.LoginRequest;
import com.nashtech.assignment.ecommerce.payload.request.RegisterCustomer;
import com.nashtech.assignment.ecommerce.payload.request.SignupRequest;
import com.nashtech.assignment.ecommerce.payload.respond.JwtRespond;
import com.nashtech.assignment.ecommerce.payload.respond.MessageRespond;
import com.nashtech.assignment.ecommerce.security.jwt.JwtUtils;
import com.nashtech.assignment.ecommerce.security.serviceImpl.UserDetailImpl;
import com.nashtech.assignment.ecommerce.service.CustomerService;
import com.nashtech.assignment.ecommerce.service.UserService;
import com.nashtech.assignment.ecommerce.services.impl.AuthServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthServiceImpl authServiceImpl;
	
	
	
	
	


	@Autowired
	public AuthController(AuthServiceImpl authServiceImpl) {
		this.authServiceImpl = authServiceImpl;
	}


	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser( @Valid @RequestBody LoginRequest loginRequest)
	{
		return this.authServiceImpl.loginAccount(loginRequest);	
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> continueRegisterCustomer( @Valid @RequestBody RegisterCustomer registerCustomer)
	{
		return this.authServiceImpl.continueRegisterCustomer(registerCustomer);		
	}
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest)
	{
		return this.authServiceImpl.registerUser(signupRequest);	
	}
	


	
	
	
	
	
	


	
	
	

}
