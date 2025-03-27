package com.ajackus.DigitalLibraryBookManagementSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajackus.DigitalLibraryBookManagementSystem.entity.Book;

@Repository
public class BookDao {

	@Autowired
	SessionFactory factory;

	public String addBook(Book book) {
		String msg;
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				session.persist(book);
				tx.commit();
				msg = "Book Added Successfully...";
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Failed to add Book!: " + e.getMessage();
				e.printStackTrace();
			}
			return msg;
		}

	}

	public List<Book> getAllBook() {
		String hqlQuery = "from Book";
		List<Book> bookList = null;
		try (Session session = factory.openSession()) {
			Query<Book> query = session.createQuery(hqlQuery, Book.class);
			bookList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	public Book getBookById(long id) {
		Book book = null;
		try (Session session = factory.openSession()) {
			book = session.get(Book.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public String updateBook(long id, Book book) {
		String msg = null;
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				Book b = session.get(Book.class, id);
				if (b != null) {
					b.setTitle(book.getTitle());
					b.setAuthor(book.getAuthor());
					b.setGenre(book.getGenre());
					b.setAvailabilityStatus(book.getAvailabilityStatus());
					session.merge(b);
					tx.commit();
					msg = "Book Updated Successfully...";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Book Not Updated! : " + e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String deleteBook(long id) {
		String msg = null;
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				Book book = session.get(Book.class, id);
				if (book != null) {
					session.remove(book);
					tx.commit();
					msg = "Book Deleted Successfully...";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Book Not Deleted! : " + e.getMessage();
				e.printStackTrace();
			}
			return msg;
		}
	}
}
