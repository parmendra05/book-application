package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.BookDto;
import com.pack.entity.Book;
import com.pack.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/get-books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping("/save-book")
	public ResponseEntity<BookDto> saveBook(@RequestBody BookDto dto) {
		BookDto savedBook = bookService.saveBook(dto);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@PutMapping("/update-book/{id}")
	public ResponseEntity<BookDto> updateBookBy(@RequestBody BookDto dto, @PathVariable(name = "id") Long id) {
		BookDto savedBook = bookService.updateBook(dto, id);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete-book/{id}")
	public ResponseEntity<String> deleteBookBy(@PathVariable(name = "id") Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
