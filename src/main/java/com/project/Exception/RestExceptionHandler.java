package com.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.Message;


@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Message> resourceNotFoundException(ResourceNotFoundException ex){
		Message msg=new Message(ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);	
	}
}
