package com.nashtech.assignment.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nashtech.assignment.ecommerce.DTO.request.BanRequest;
import com.nashtech.assignment.ecommerce.DTO.request.UnbanRequest;
import com.nashtech.assignment.ecommerce.DTO.request.UserRequestDTO;
import com.nashtech.assignment.ecommerce.DTO.request.UserUpdateDTO;
import com.nashtech.assignment.ecommerce.DTO.request.VertiRequest;
import com.nashtech.assignment.ecommerce.DTO.respond.MessageRespond;
import com.nashtech.assignment.ecommerce.DTO.respond.UserRespondDTO;
import com.nashtech.assignment.ecommerce.data.entities.Banned;
import com.nashtech.assignment.ecommerce.data.entities.EmailDetail;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.data.repository.BannedRepository;
import com.nashtech.assignment.ecommerce.data.repository.UserRepository;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;
import com.nashtech.assignment.ecommerce.security.localuser.UserLocal;
import com.nashtech.assignment.ecommerce.service.EmailService;
import com.nashtech.assignment.ecommerce.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	
	private BannedRepository bannedRepository;
	
	private EmailService emailService;
	
	
	private UserLocal userLocal;
	
	@Autowired
	public UserServiceImpl( UserRepository userRepository, ModelMapper modelMapper, UserLocal userLocal, BannedRepository bannedRepository,
			EmailService emailService) 
	{
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.userLocal = userLocal;
		this.bannedRepository = bannedRepository;
		this.emailService = emailService;
	}

	@Override
	public List<UserRespondDTO> getAllUsers() 
	{
		List<Users> userList =  this.userRepository.findAll();
		
		if(userList.isEmpty()) {
			throw new ResourceNotFoundException("Dont have any user yet");
		}
		
		List<UserRespondDTO> listUserRespond = new ArrayList<UserRespondDTO>();
		
		userList.forEach(user-> {
			UserRespondDTO userRespondDTO = modelMapper.map(user, UserRespondDTO.class);
			userRespondDTO.setRole(user.getRoles().getRoleName());
			listUserRespond.add(userRespondDTO);
		} );
		return listUserRespond;
	}



	@Override
	public UserRespondDTO findUserByName(String userName)
	{
		
		Optional<Users> userOptional = this.userRepository.findByUserName(userName);
		
		if(userOptional.isPresent()) 
		{
			Users users = userOptional.get();
			UserRespondDTO userFound = modelMapper.map(users, UserRespondDTO.class);
			userFound.setRole(users.getRoles().getRoleName());
			return userFound;
		}
		
		throw new ResourceNotFoundException("User Not Found");		
	}

	@Override
	public UserRespondDTO updateUsers(UserUpdateDTO userUpdateDTO)
	{
	      String localUserName = userLocal.getLocalUser();
	      if(localUserName != null) {
	    	  int id = userRepository.getIdByName(localUserName);
	    	  Users users = modelMapper.map(userUpdateDTO, Users.class);
	    	  users.setUserId(id);
	    	  Users savedUser =  this.userRepository.save(users);
	    	  UserRespondDTO userRespondDTO = modelMapper.map(savedUser, UserRespondDTO.class);
	    	  userRespondDTO.setRole(users.getRoles().getRoleName());
	    	  return userRespondDTO;
	      }
	      throw new UnAuthorizationException("Please Login First");
	}

	@Override
	public ResponseEntity<?> blockUser(BanRequest banRequest) {
		Optional<Users> userOptional = userRepository.findByUserName(banRequest.getUserName());
		if(userOptional.isPresent()) 
		{
			Users users = userOptional.get();
			users.setStatus(false);
			Users bannedUsers = this.userRepository.save(users);
			Banned banned = modelMapper.map(banRequest,Banned.class);
			banned.setUsers(bannedUsers);
			this.bannedRepository.save(banned);
			return ResponseEntity.ok(new MessageRespond(HttpStatus.OK.value(), "Block Success User " + banRequest.getUserName()));
		}
		throw new ResourceNotFoundException("User Not Found With Name: " + banRequest.getUserName());
	}

	@Override
	public ResponseEntity<?> unbanUser(VertiRequest vertiRequest) {
		Optional<Users> userOptional = this.userRepository.findByUserName(vertiRequest.getUserName());
		if(userOptional.isPresent()) 
		{
			Users users = userOptional.get();
			Banned banned = this.bannedRepository.getBannedAccount(users.getUserId());
			String vertiCodeExpect = banned.getUnbanCode();
			String vertiCodeReceived = vertiRequest.getVertiCode();
			if( vertiCodeExpect.equals(vertiCodeReceived)) 
			{
				users.setStatus(true);
				this.userRepository.save(users);
				System.out.println(banned.getBannedId());
				this.bannedRepository.deleteBanned(banned.getBannedId());
				return ResponseEntity.ok(new MessageRespond(HttpStatus.OK.value(), "Unban Success !"));
			}
			throw new UnAuthorizationException("Wrong Verti code");
		}
		throw new ResourceNotFoundException("This User Has Not Been Blocked");
	}
	
	
	
	
	public String generateValidationCode() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
        String randomArray = "0123456789qwertyuiopasdfghjklzxcvbnm{}?></.,";
		for(int i =0; i<10; i++) 
		{
			int selector = random.nextInt(randomArray.length());
			builder.append(randomArray.charAt(selector));
		}
		return builder.toString();
	}

	@Override
	public ResponseEntity<?> sendUnbanRequest(UnbanRequest unbanRequest) 
	{
		Optional<Users> userOptional = this.userRepository.findByUserName(unbanRequest.getUserName());
		if(userOptional.isPresent())
		{
			Users bannedUsers = userOptional.get();
			System.out.println("1");
			String userEmail = bannedUsers.getUserEmail();
			String vertiCode = generateValidationCode();
			System.out.println("2");
			EmailDetail emailDetail = new EmailDetail(userEmail, vertiCode, "Unblock Code");
			emailService.sendVertiCode(emailDetail);
			System.out.println("3");
			this.bannedRepository.saveVertiCode(vertiCode, bannedUsers.getUserId());
			return ResponseEntity.ok(new MessageRespond(HttpStatus.OK.value(), "Verification Code Sent Success"));
		}
		
		throw new ResourceNotFoundException("User Not Found");
	}
	


	
	



	
	
	

}
