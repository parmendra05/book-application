package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	@GeneratedValue
	private Long bookId;
	private String bookName;
	private String author;
	private Integer price;

}
