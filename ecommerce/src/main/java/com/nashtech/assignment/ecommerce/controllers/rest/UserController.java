package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) 
	{
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public List<Users> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	
	/*@PostMapping("/create")
	public void addNewUser(Users user) {
		
	}*/
	
	

}
