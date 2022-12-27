package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dto.BookDto;
import com.pack.entity.Book;
import com.pack.exception.ResourseNotFoundException;
import com.pack.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {

		return bookRepository.findAll();
	}

	@Override
	public BookDto saveBook(BookDto dto) {
		Book bookObj = convertDtoToEntity(dto);
		Book savedBook = bookRepository.save(bookObj);
		return convertEntityToDto(savedBook);
	}

	@Override
	public BookDto updateBook(BookDto dto, Long id) throws ResourseNotFoundException {
		Book savedBook = bookRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Book", "book_id", id));

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
