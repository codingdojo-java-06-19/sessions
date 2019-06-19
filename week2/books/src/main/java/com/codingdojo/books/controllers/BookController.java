package com.codingdojo.books.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String index(Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userId");
		
		if (id == null) {
			return "redirect:/";
		}
		
		
		List<Book> books = bookService.findAllBooks();
		
		model.addAttribute("books", books);
		
		return "books/index.jsp";
	}
	
//	@PostMapping("")
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		final String page = result.hasErrors() ? "books/new.jsp" : "redirect:/books";
		
		if (!result.hasErrors()) {
			bookService.create(book);			
		}
		
		return page;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		final String page = result.hasErrors() ? "books/edit.jsp" : "redirect:/books";
		
		if (!result.hasErrors()) {
			bookService.update(book);
		}
		
		return page;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	public String destroy(@PathVariable("id") Long id) {
		bookService.removeBook(id);
		
		return "redirect:/books";
	}
	
}







