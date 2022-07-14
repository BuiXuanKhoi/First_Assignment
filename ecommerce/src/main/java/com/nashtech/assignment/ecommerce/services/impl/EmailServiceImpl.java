package com.nashtech.assignment.ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.nashtech.assignment.ecommerce.DTO.respond.MessageRespond;
import com.nashtech.assignment.ecommerce.data.entities.EmailDetail;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public ResponseEntity<?> sendVertiCode(EmailDetail emailDetail) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetail.getRecipient());
			mailMessage.setText(emailDetail.getMessage());
			mailMessage.setSubject(emailDetail.getSubject());
			
			System.out.println(sender);
			System.out.println(emailDetail.getRecipient());
			System.out.println(emailDetail.getMessage());
			System.out.println(emailDetail.getSubject());
			
			javaMailSender.send(mailMessage);
			
			return ResponseEntity.ok(new MessageRespond(HttpStatus.OK.value(), "Email Sent Success"));
			
		} catch (Exception e) {
			throw new ResourceNotFoundException("Email cannot sent because wrong recipient " + e.getMessage());
		}
	}

}
