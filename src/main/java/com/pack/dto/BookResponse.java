package com.pack.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookResponse {
	private List<BookDto> books;
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalElements;
	private Integer totalPages;
	private Boolean isLast;

}
