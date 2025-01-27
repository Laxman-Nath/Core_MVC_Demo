package com.mvc.service;

import java.util.List;

import com.mvc.models.Book;


public interface BookService {
	void addBook(Book b);

	List<Book> findAllBooks();

	Book getBookById(int id);

	void updateBook(int id,Book b);

	void deleteBookById(int id);
}
