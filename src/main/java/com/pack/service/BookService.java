package com.pack.service;

import java.util.List;

import com.pack.dto.BookDto;
import com.pack.entity.Book;
import com.pack.exception.ResourseNotFoundException;

public interface BookService {

	List<Book> getAllBooks();

	BookDto saveBook(BookDto dto);

	BookDto updateBook(BookDto dto, Long id) throws ResourseNotFoundException;

	void deleteBook(Long id) throws ResourseNotFoundException;

}
