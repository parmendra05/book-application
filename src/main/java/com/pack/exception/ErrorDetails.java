package com.pack.exception;

import java.util.Date;


public class ErrorDetails {
	private Date timestamp;
	private String messasge;
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessasge() {
		return messasge;
	}

	public void setMessasge(String messasge) {
		this.messasge = messasge;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
