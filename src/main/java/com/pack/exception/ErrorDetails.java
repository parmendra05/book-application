package com.pack.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails {
private Date timestamp;
private String messasge;
private String details;
}
