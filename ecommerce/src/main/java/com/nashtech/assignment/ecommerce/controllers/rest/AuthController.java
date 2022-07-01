package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	
	private final UserRepository userRepository;
	
	private final RoleRepository roleRepository;
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	private final CustomerService customerService;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	private final JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, CustomerRepository customerRepository, CustomerService customerService) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.customerRepository = customerRepository;
		this.customerService = customerService;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtils = jwtUtils;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
	{
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getUserPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtils.generateToken(authentication);
		
		UserDetailImpl userDetailImpl = (UserDetailImpl) authentication.getPrincipal();
		List<String> roles = userDetailImpl.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtRespond(jwt, 
												userDetailImpl.getId(), 
												userDetailImpl.getUsername(), 
												userDetailImpl.getUserEmail(), 
												roles));
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> continueRegisterCustomer(@Valid @RequestBody RegisterCustomer registerCustomer)
	{
		Optional<Users> usersOptional = userRepository.findById(registerCustomer.getUserId());
		if(usersOptional.isPresent()) 
		{
			Users users = usersOptional.get();
			users.setUserPassword(passwordEncoder.encode(users.getUserPassword()));
			Customers customers = new Customers(users,
												registerCustomer.getCustomerDateOfBirth(),
												registerCustomer.getCustomerAddres(),
												registerCustomer.getCustomerPhoneNumber());
			
			Customers savedCustomers = customerService.registerNewCustomers(customers);
			return ResponseEntity.ok(new MessageRespond("Customer Register Success"));
		}
		
		throw new ResourceNotFoundException("User ID Not Found");
		
		
	}
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		if(userRepository.isUsernameExisted(signupRequest.getUserName())) 
		{
			return ResponseEntity.badRequest().body(new MessageRespond("Error : User name has been taken !"));
		}
		
		if(userRepository.isEmailExisted(signupRequest.getUserEmail())) 
		{
			return ResponseEntity.badRequest().body(new MessageRespond("Error : Email is already in use ! "));
		}
		
		Users users = new Users( signupRequest.getUserEmail(),
								signupRequest.getUserName(), 
								passwordEncoder.encode(signupRequest.getUserPassword()));
		
		String roles = signupRequest.getRole();
		
		Optional<Roles> roleOptional = roleRepository.findRoleByName(roles);
		
		if(roleOptional.isPresent())
		{
			Roles roleEntity = roleOptional.get();
			users.setRoles(roleEntity);
			userRepository.save(users);
			
			return ResponseEntity.ok(new MessageRespond("Register Successfulyl !"));
		}
		
		throw new ResourceNotFoundException("Cannot find that Roles");
		
	}
	


	
	
	
	
	
	


	
	
	

}
