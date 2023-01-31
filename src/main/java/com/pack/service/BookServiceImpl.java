package com.pack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pack.dto.BookDto;
import com.pack.dto.BookResponse;
import com.pack.entity.Book;
import com.pack.exception.ResourseNotFoundException;
import com.pack.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookResponse getAllBooks(int pageNum, int pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);

		Page<Book> bookResponse = bookRepository.findAll(pageable);

		// Convert PageObject into Entity
		List<Book> listOfBooks = bookResponse.getContent();

		// Convert BookObject into DTO
		List<BookDto> dtoResponses = listOfBooks.stream().map(book -> convertEntityToDto(book))
				.collect(Collectors.toList());

		// prepare Response
		BookResponse response = new BookResponse();
		response.setBooks(dtoResponses);
		response.setPageNum(bookResponse.getNumber());
		response.setPageSize(bookResponse.getSize());
		response.setTotalElements(bookResponse.getNumberOfElements());
		response.setTotalPages(bookResponse.getTotalPages());
		response.setIsLast(bookResponse.isLast());
		return response;
	}

	@Override
	public BookDto saveBook(BookDto dto) {
		Book bookObj = convertDtoToEntity(dto);
		Book savedBook = bookRepository.save(bookObj);
		return convertEntityToDto(savedBook);
	}

	@Override
	public BookDto updateBook(BookDto dto, Long id) throws ResourseNotFoundException {
		Book savedBook = bookRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Book", "book_id", id));

		savedBook.setBookName(dto.getBookName());
		savedBook.setAuthor(dto.getAuthor());
		savedBook.setPrice(dto.getPrice());

		Book updatedBook = bookRepository.save(savedBook);
		return convertEntityToDto(updatedBook);

	}

	@Override
	public void deleteBook(Long id) throws ResourseNotFoundException {
		bookRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Book", "book_id", id));
		bookRepository.deleteById(id);

	}

	private Book convertDtoToEntity(BookDto bookDto) {
		Book book = new Book();
		book.setBookId(bookDto.getBookId());
		book.setBookName(bookDto.getBookName());
		book.setAuthor(bookDto.getAuthor());
		book.setPrice(bookDto.getPrice());
		return book;
	}

	private BookDto convertEntityToDto(Book book) {
		BookDto dto = new BookDto();
		dto.setBookId(book.getBookId());
		dto.setBookName(book.getBookName());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(book.getPrice());
		return dto;
	}

}
