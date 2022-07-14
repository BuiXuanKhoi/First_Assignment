package com.nashtech.assignment.ecommerce.controllers.rest;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.ecommerce.DTO.request.BanRequest;
import com.nashtech.assignment.ecommerce.DTO.request.UnbanRequest;
import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.UserUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.request.VertiRequest;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.UserService;

import net.bytebuddy.asm.Advice.Return;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) 
	{
		this.userService = userService;
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<UserRespondDTO> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	
	
	@PutMapping
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public UserRespondDTO updateUsers(@RequestBody UserUpdateDTO userUpdateDTO) {
		return this.userService.updateUsers(userUpdateDTO);
	}
	

	
	@GetMapping("/{name}")
	@PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('ADMIN')")
	public UserRespondDTO findUserByName(@PathVariable("name") String name){
		return this.userService.findUserByName(name);
	}
	
	@PostMapping("/status")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> blockUser(@RequestBody BanRequest banRequest){
		return this.userService.blockUser(banRequest);
	}
	
	@PutMapping("/vertify")
	@PreAuthorize("permitAll()")
	@PermitAll
	public ResponseEntity<?> sendUnbanCode(@RequestBody UnbanRequest unbanRequest){
		System.out.println("Unban");
		return this.userService.sendUnbanRequest(unbanRequest);
	}
	
	@PutMapping("/status")
	@PreAuthorize("permitAll()")
	@PermitAll
	public ResponseEntity<?> unbanUser(@RequestBody VertiRequest vertiRequest){
		return this.userService.unbanUser(vertiRequest);
	}

	

	
	
	
	

}
