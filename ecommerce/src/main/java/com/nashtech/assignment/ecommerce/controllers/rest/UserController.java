package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.UserService;

import net.bytebuddy.asm.Advice.Return;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) 
	{
		this.userService = userService;
	}
	
	@GetMapping
	public List<Users> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	
	
	
	@RequestMapping( method = RequestMethod.POST)
	public Users addNewUser(@Validated @RequestBody Users users)
	{
			users.setUserId(0);
			return this.userService.addNewUser(users);	
	}
	
	@PutMapping
	public Users updateUsers(@RequestBody Users users) {
		return this.userService.updateUsers(users);
	}
	
	@DeleteMapping
	public void deleteUserById(@RequestBody int id) {
			this.userService.deleteUserById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Users> findUserById(@PathVariable("id") int id){
		Optional<Users> users = this.userService.findUserById(id);
		
		if(users.isPresent()) {
			return users;
		}
		
		throw new ResourceNotFoundException("404" + " Cannot Find User Id");
	}
	
	//Throw exception when error instead null.
	
	
	
	

}
