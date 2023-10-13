package com.pack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.BookDto;
import com.pack.dto.BookResponse;
import com.pack.entity.Book;
import com.pack.exception.ResourseNotFoundException;
import com.pack.service.BookService;
import com.pack.util.AppConstraints;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/get-books")

	public BookResponse getAllBooks(@RequestParam(value = "pageNum", defaultValue = AppConstraints.DEFAULT_PAGE_NUM, required = false) int pageNum,
			@RequestParam(value = "pageSize", defaultValue = AppConstraints.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstraints.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstraints.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {

		BookResponse response = bookService.getAllBooks(pageNum, pageSize, sortBy, sortDir);
		return response;
	}

	@PostMapping("/save-book")
	public ResponseEntity<BookDto> saveBook(@Valid @RequestBody BookDto dto) {
		BookDto savedBook = bookService.saveBook(dto);
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
	}

	@PutMapping("/update-book/{id}")
	public ResponseEntity<BookDto> updateBookBy(@Valid @RequestBody BookDto dto, @PathVariable(name = "id") Long id)
			throws ResourseNotFoundException {
		BookDto savedBook = bookService.updateBook(dto, id);
		return new ResponseEntity<>(savedBook, HttpStatus.OK);
	}

	@DeleteMapping("/delete-book/{id}")
	public ResponseEntity<String> deleteBookBy(@PathVariable(name = "id") Long id) throws ResourseNotFoundException {
		bookService.deleteBook(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/geting-books")
	public List<Book> getAllBooks() {
		List<Book> response = bookService.getListOfBooks();
		return response;
	}
}
