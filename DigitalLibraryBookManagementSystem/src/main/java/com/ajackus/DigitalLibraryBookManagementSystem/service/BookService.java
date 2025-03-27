package com.ajackus.DigitalLibraryBookManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajackus.DigitalLibraryBookManagementSystem.dao.BookDao;
import com.ajackus.DigitalLibraryBookManagementSystem.entity.Book;

@Service
public class BookService {
	
	@Autowired
	BookDao dao;
	
	public String addBook(Book book) {
		String msg = dao.addBook(book);
		return msg;
	}

	public List<Book> getAllBook() {
		List<Book> bookList = dao.getAllBook();
		return bookList;
	}

	public Book getBookById(long id) {
		Book book = dao.getBookById(id);
		return book;
	}

	public String updateBook(long id, Book book) {
		String msg = dao.updateBook(id,book);
		return msg;
	}

	public String deleteBook(long id) {
		String msg = dao.deleteBook(id);
		return msg;
	}

}
