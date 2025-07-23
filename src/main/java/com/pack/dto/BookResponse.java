package com.pack.dto;

import java.util.List;




public class BookResponse {
	private List<BookDto> books;
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalElements;
	private Integer totalPages;
	private Boolean isLast;

	public List<BookDto> getBooks() {
		return books;
	}

	public void setBooks(List<BookDto> books) {
		this.books = books;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Boolean getLast() {
		return isLast;
	}

	public void setLast(Boolean last) {
		isLast = last;
	}
}
