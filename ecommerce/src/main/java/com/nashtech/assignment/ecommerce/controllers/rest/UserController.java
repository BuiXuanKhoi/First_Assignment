package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
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
	@PreAuthorize("hasRole('Admin')")
	public List<UserRespondDTO> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	
	
	
	@PostMapping
	public UserRespondDTO addNewUser(@Validated @RequestBody UserRequestDTO userRequestDTO)
	{
			userRequestDTO.setUserId(0);
			return this.userService.addNewUser(userRequestDTO);	
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
