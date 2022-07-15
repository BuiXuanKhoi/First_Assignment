package com.nashtech.assignment.ecommerce.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.ecommerce.data.entities.Admin;
import com.nashtech.assignment.ecommerce.data.entities.Customers;
import com.nashtech.assignment.ecommerce.data.entities.Roles;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.AdminRepository;
import com.nashtech.assignment.ecommerce.data.repository.CustomerRepository;
import com.nashtech.assignment.ecommerce.data.repository.RoleRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ApiDeniedException;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;
import com.nashtech.assignment.ecommerce.payload.request.LoginRequest;
import com.nashtech.assignment.ecommerce.payload.request.RegisterAdmin;
import com.nashtech.assignment.ecommerce.payload.request.RegisterCustomer;
import com.nashtech.assignment.ecommerce.payload.request.SignupRequest;
import com.nashtech.assignment.ecommerce.payload.respond.JwtRespond;
import com.nashtech.assignment.ecommerce.payload.respond.MessageRespond;
import com.nashtech.assignment.ecommerce.security.jwt.JwtAuthTokenFilter;
import com.nashtech.assignment.ecommerce.security.jwt.JwtUtils;
import com.nashtech.assignment.ecommerce.security.serviceImpl.UserDetailImpl;
import com.nashtech.assignment.ecommerce.service.AuthService;
import com.nashtech.assignment.ecommerce.service.CustomerService;
import com.nashtech.assignment.ecommerce.service.UserService;


@Service
public class AuthServiceImpl implements AuthService {
	
	private final CustomerRepository customerRepository;
	
	private final UserRepository userRepository;
	
	private final JwtUtils jwtUtils;
	
	private final JwtAuthTokenFilter jwtAuthTokenFilter;
	
	private final RoleRepository roleRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	private final CustomerService customerService;
	
	private final AdminRepository adminRepository;
	
	private final UserService userService;
	
	

	
	@Autowired
	public AuthServiceImpl(CustomerRepository customerRepository, UserRepository userRepository, JwtUtils jwtUtils,
			JwtAuthTokenFilter jwtAuthTokenFilter, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, CustomerService customerService, AdminRepository adminRepository, UserService userService) {
		this.customerRepository = customerRepository;
		this.userRepository = userRepository;
		this.jwtUtils = jwtUtils;
		this.jwtAuthTokenFilter = jwtAuthTokenFilter;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.customerService = customerService;
		this.adminRepository = adminRepository;
		this.userService = userService;
	}



	@Override
	public ResponseEntity<?> registerUser(SignupRequest signupRequest)
	{
		
		Optional<Users> userByEmail = userRepository.findByEmail(signupRequest.getUserEmail());
		Optional<Users> userByName = userRepository.findByUserName(signupRequest.getUserName());
		
		if(userByName.isPresent()) 
		{
			return ResponseEntity.badRequest().body(new MessageRespond("Error : User name has been taken !"));
		}
		
		if(userByEmail.isPresent()) 
		{
			return ResponseEntity.badRequest().body(new MessageRespond("Error : Email is already in use ! "));
		}
		
		//Register User
		
		Users users = new Users( signupRequest.getUserEmail(),
								signupRequest.getUserName(), 
								passwordEncoder.encode(signupRequest.getUserPassword())); // Because we cannot store password as text in database
		
		String roles = signupRequest.getRole();
		
		Optional<Roles> roleOptional = roleRepository.findRoleByName(roles);
		
		if(roleOptional.isPresent())
		{
			Roles roleEntity = roleOptional.get();
			users.setRoles(roleEntity);
			users.setUserId(0);
			users.setStatus(true);
			userRepository.save(users);	
			return ResponseEntity.ok(new MessageRespond("Register Successfulyl !"));
		}
		
		throw new ResourceNotFoundException("Cannot find that Roles");	
//		catch (Exception e) 
//		{
//			return ResponseEntity.badRequest().body((new MessageRespond("Fail Signup :  " + e.getMessage() + "  " + signupRequest.getUserPassword() + "  " + signupRequest.getUserEmail())));
//		}
	}



	@Override
	public ResponseEntity<?> continueRegisterCustomer(RegisterCustomer registerCustomer) {
		Optional<Users> usersOptional = userRepository.findById(registerCustomer.getUserId());
		if(usersOptional.isPresent()) 
		{
			Users users = usersOptional.get();
			if(users.getCatogeryUserId() == 1)
			{
				users.setUserPassword(passwordEncoder.encode(users.getUserPassword()));
				Customers customers = new Customers(users,
												registerCustomer.getCustomerDateOfBirth(),
												registerCustomer.getCustomerAddres(),
												registerCustomer.getCustomerPhoneNumber());
			
				Customers savedCustomers = customerService.registerNewCustomers(customers);
				return ResponseEntity.ok(new MessageRespond("Customer Register Success"));
			}
			throw new UnAuthorizationException("Cannot register due to wrong Role");
		}
		
		throw new ResourceNotFoundException("User ID Not Found");
	}



	@Override
	public ResponseEntity<?> loginAccount(LoginRequest loginRequest) {
		try {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getUserPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtils.generateToken(authentication);
		
		UserDetailImpl userDetailImpl = (UserDetailImpl) authentication.getPrincipal();
		List<String> roles = userDetailImpl.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		Users user = this.userRepository.findByUserName(userDetailImpl.getUsername()).get();
		
		if(user.getStatus())
		{
			return ResponseEntity.ok(new JwtRespond(jwt, 
					userDetailImpl.getId(), 
					userDetailImpl.getUsername(), 
					userDetailImpl.getUserEmail(), 
					roles.get(0)));
		}
		
		throw new UnAuthorizationException("User Account Has Been Locked");

		}catch (Exception e) {
			throw new ResourceNotFoundException("Cannot Login :  " + e.getMessage());
		}

	}



	@Override
	public ResponseEntity<?> continueRegisterAdmin(RegisterAdmin registerAdmin) 
	{
		Optional<Users> userOptional = this.userRepository.findById(registerAdmin.getUserId());
		
		if(userOptional.isPresent())
		{
			Users users = userOptional.get();
			if(users.getCatogeryUserId() == 2) 
			{
				users.setUserPassword(passwordEncoder.encode(users.getUserPassword()));
				Admin admin = new Admin(0,registerAdmin.getAdminGender(), users);
				Admin savedAdmin = this.adminRepository.save(admin);
				return ResponseEntity.ok("Register Admin Success");
			}
			throw new UnAuthorizationException("Cannot register due to wrong Role");
		}
		throw new ResourceNotFoundException("User ID Not Found");
	}
	
	
	
	

	
	

}
