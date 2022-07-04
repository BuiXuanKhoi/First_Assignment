package com.nashtech.assignment.ecommerce.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nashtech.assignment.ecommerce.DTO.respond.ErrorResponse;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;
import net.bytebuddy.asm.Advice.Return;


@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleNotFoundException( ResourceNotFoundException rsnf){
		
		int statusCode = HttpStatus.NOT_FOUND.value();
		String message = rsnf.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message); 
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleWrongArgumentException( IllegalArgumentException ilex){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = ilex.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleNotNumberException(NumberFormatException numex){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = numex.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleMethodTypeMisMatchException(MethodArgumentTypeMismatchException mistmatch){
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = mistmatch.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodNotValid){
		
		Map<String, String> errors = new HashMap<String, String>();
		
		methodNotValid.getBindingResult().getAllErrors().forEach((error) ->{
			String name = ((FieldError) error ).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(name, errorMessage);
		});
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String message = methodNotValid.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message, errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleUnauthorizationException(UnAuthorizationException unauth){
		int statusCode = HttpStatus.UNAUTHORIZED.value();
		String message = unauth.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode,  message);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);	
	}
	
	
	
	


}
