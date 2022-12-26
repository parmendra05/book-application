package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
