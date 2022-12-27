package com.pack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourseNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	private String resourceName;
	private String fieldName;
	private Long fieldValue;

	public ResourseNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s :%s ", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Long getFieldValue() {
		return fieldValue;
	}

}
