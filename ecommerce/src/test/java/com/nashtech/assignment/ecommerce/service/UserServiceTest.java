package com.nashtech.assignment.ecommerce.service;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.AssertionErrors;

import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Roles;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.services.impl.UserServiceImpl;

public class UserServiceTest {
	
	UserService userService;
	
	UserRepository userRepository;
	
	UserServiceImpl userServiceImpl;
	
	Users users;
	
	UserRespondDTO userRespondDTO;
	
	ModelMapper modelMapper;
	
	Roles roles;
	
	UserLocal userLocal;


	@BeforeEach
	public void init() {
		userService = mock(UserService.class);
		userRepository = mock(UserRepository.class);
		userServiceImpl = mock(UserServiceImpl.class);
		users = mock(Users.class);
		userRespondDTO = mock(UserRespondDTO.class);
		modelMapper = mock(ModelMapper.class);
		roles = mock(Roles.class);
		userLocal = mock(UserLocal.class);
	}
	

	
	@Test
	public void whenFindUserName_shouldReturnUser_whenUserFound() {
		when(userRepository.findByUserName("Le Thanh Nghi")).thenReturn(Optional.of(users));
		when(modelMapper.map(userRespondDTO, Users.class)).thenReturn(users);
		Users expectUser = modelMapper.map(userServiceImpl.findUserByName("Le Thanh Nghi"), Users.class) ;
		verify(users).setRoles(roles);
		assertEquals(users, expectUser);
	}
	
	@Test
	public void whenFindUserName_throwResourceNotFound_whenUserNotFound() {
		when(userRepository.findByUserName("NaN")).thenReturn(Optional.empty());
		ResourceNotFoundException resourceNotFoundException = assertThrows(ResourceNotFoundException.class,
				()->userServiceImpl.findUserByName("NaN"));
		assertEquals(resourceNotFoundException.getMessage(),"User Not Found");
	}
	
	public void whenUpdateUser_shouldReturnUser_whenUserFound() {
		
		String localUserName = "Khoi";
		when(userLocal.getLocalUser()).thenReturn(localUserName);
		
	}

}
