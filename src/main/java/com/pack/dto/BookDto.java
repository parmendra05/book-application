package com.pack.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;




public class BookDto {
	private Long bookId;

	@NotBlank(message = "please provide the name for book")
	private String bookName;

	@NotEmpty
	private String author;

	private Integer price;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public @NotBlank(message = "please provide the name for book") String getBookName() {
		return bookName;
	}

	public void setBookName(@NotBlank(message = "please provide the name for book") String bookName) {
		this.bookName = bookName;
	}

	public @NotEmpty String getAuthor() {
		return author;
	}

	public void setAuthor(@NotEmpty String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
