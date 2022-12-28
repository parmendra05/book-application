package com.pack.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BookApiExceptionHandler {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFounfExceptionHandler(ResourseNotFoundException exception, WebRequest request){
		
		ErrorDetails error=new ErrorDetails();
		error.setTimestamp(new Date());
		error.setMessasge(exception.getMessage());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
