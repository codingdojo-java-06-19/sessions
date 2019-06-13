package com.codingdojo.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> findAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		
		if (book.isPresent()) {
			return book.get();
		}
		
		return null;
	}
	
	public Book update(Long id, String title, String publisher, Integer pages) {
		Book book = findById(id);
		
		book.setPages(pages);
		book.setTitle(title);
		book.setPublisher(publisher);
		
		return update(book);
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public void removeBook(Long id) {
		bookRepo.deleteById(id);
	}
}
