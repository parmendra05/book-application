package com.pack.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BookApiExceptionHandler {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFounfExceptionHandler(ResourseNotFoundException exception,
			WebRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setTimestamp(new Date());
		error.setMessasge(exception.getMessage());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> dataValidator(MethodArgumentNotValidException exception) {
		Map<String, String> errorList = new HashMap<>();

		exception.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errorList.put(fieldName, message);
		});
		return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
	}

	// Global Exception handler handle every types of excetion, in case of new
	// exception occurs
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalfExceptionHandler(Exception exception, WebRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setTimestamp(new Date());
		error.setMessasge(exception.getMessage());
		error.setDetails(request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
