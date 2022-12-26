package com.pack.dto;

import lombok.Data;

@Data
public class BookDto {
	private Long bookId;
	private String bookName;
	private String author;
	private Integer price;
}
