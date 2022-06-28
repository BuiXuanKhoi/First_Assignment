package com.nashtech.assignment.ecommerce.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nashtech.assignment.ecommerce.data.entities.ErrorResponse;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;


@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleNotFoundException( ResourceNotFoundException rsnf){
		
		int statusCode = HttpStatus.NOT_FOUND.value();
		String message = rsnf.getMessage();
		long time = System.currentTimeMillis();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message, time); 
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleWrongArgumentException( IllegalArgumentException ilex){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = ilex.getMessage();
		long time = System.currentTimeMillis();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message, time);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleNotNumberException(NumberFormatException numex){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = numex.getMessage();
		long time = System.currentTimeMillis();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message, time);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleMethodTypeMisMatchException(MethodArgumentTypeMismatchException mistmatch){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = mistmatch.getMessage();
		long time = System.currentTimeMillis();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message, time);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	
	


}
