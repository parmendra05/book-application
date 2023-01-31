package com.pack.service;

import com.pack.dto.BookDto;
import com.pack.dto.BookResponse;
import com.pack.exception.ResourseNotFoundException;

public interface BookService {

	BookResponse getAllBooks(int pageNum, int pageSize, String sortBy, String sortDir);

	BookDto saveBook(BookDto dto);

	BookDto updateBook(BookDto dto, Long id) throws ResourseNotFoundException;

	void deleteBook(Long id) throws ResourseNotFoundException;

}
