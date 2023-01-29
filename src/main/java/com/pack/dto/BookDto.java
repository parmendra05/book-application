package com.pack.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BookDto {
	private Long bookId;
	
	@NotBlank(message ="please provide the name for book" )
	private String bookName;
	
	@NotEmpty
	private String author;
	
	private Integer price;
}
