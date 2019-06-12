package com.codingdojo.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<Book> books = bookService.findAllBooks();
		
		model.addAttribute("books", books);
		
		return "books/index.jsp";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@RequestParam("title") String title) {
		Book book = new Book();
		
		book.setTitle(title);
		
		bookService.create(book);
		
		return "redirect:/books";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		
		return "books/show.jsp";
	}
	
	
	@RequestMapping("/new")
	public String newBook() {
		return "books/new.jsp";
	}
	
}







