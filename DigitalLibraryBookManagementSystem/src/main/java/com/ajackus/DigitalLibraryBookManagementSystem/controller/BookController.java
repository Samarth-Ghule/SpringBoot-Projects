package com.ajackus.DigitalLibraryBookManagementSystem.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajackus.DigitalLibraryBookManagementSystem.entity.Book;
import com.ajackus.DigitalLibraryBookManagementSystem.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("book")
@Validated
public class BookController {
	
	@Autowired
	BookService service;
	
	@PostMapping("addBook")
	public ResponseEntity<String> addBook(@Valid @RequestBody Book book){
		String msg = service.addBook(book);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("viewAll")
	public ResponseEntity<List <Book>> getAllBook(){
		List<Book> bookList = service.getAllBook();
		return ResponseEntity.ok(bookList);
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<?> getBookById(@PathVariable long id){
		Book book = service.getBookById(id);
		if (Objects.isNull(book)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with id : "+id);
		}
		return ResponseEntity.ok(book);
	}
	
	@PutMapping("updateBook/{id}")
	public ResponseEntity<String> updateBook(@PathVariable long id, @Valid @RequestBody Book book){
		String msg = service.updateBook(id,book);
		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id must be greater than zero!");
		}
		
		if (Objects.isNull(msg)) {
			msg = "Book Not Found with Id : "+id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteBook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable long id){
		String msg = service.deleteBook(id);
		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book Id must be greater than zero!");
		}
		
		if (Objects.isNull(msg)) {
			msg = "Book Not Found with Id : "+id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		return ResponseEntity.ok(msg);
	}
	
	@PostMapping("exit")
	public void exitApplication() {
		System.out.println("Shutting down the Digital Library Book Management System...");
		System.exit(0);
	}
}

