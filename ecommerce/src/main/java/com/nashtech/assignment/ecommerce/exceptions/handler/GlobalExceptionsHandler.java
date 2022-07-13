package com.nashtech.assignment.ecommerce.exceptions.handler;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nashtech.assignment.ecommerce.DTO.respond.ErrorResponse;
import com.nashtech.assignment.ecommerce.exception.ApiDeniedException;
import com.nashtech.assignment.ecommerce.exception.ResourceAlreadyExistException;
import com.nashtech.assignment.ecommerce.exception.ResourceNotFoundException;
import com.nashtech.assignment.ecommerce.exception.UnAuthorizationException;

import aj.org.objectweb.asm.Handle;
import net.bytebuddy.asm.Advice.Return;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler{
	
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
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request){
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//
//			System.out.println(fieldName+" "+ errorMessage);
//			errors.put(fieldName, errorMessage);
//		});
//		ErrorResponse error = new ErrorResponse(400, "Validation Error", errors);
//		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleUnauthorizationException(UnAuthorizationException unauth){
		int statusCode = HttpStatus.UNAUTHORIZED.value();
		String message = unauth.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode,  message);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);	
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleApiDeniedException(ApiDeniedException apiDeniedException){
		int statusCode = HttpStatus.FORBIDDEN.value();
		
		String message = apiDeniedException.getMessage();
		
		ErrorResponse errorResponse = new ErrorResponse(statusCode, message);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.FORBIDDEN);
	}

	
	


}
