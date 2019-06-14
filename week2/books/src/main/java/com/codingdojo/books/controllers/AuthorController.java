package com.codingdojo.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.books.models.Author;
import com.codingdojo.books.services.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	private final AuthorService authorService;
	
	public AuthorController(AuthorService service) {
		this.authorService = service;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		return "authors/index.jsp";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("author") Author author, BindingResult result) {
		final String page = result.hasErrors() ? "authors/new.jsp" : "redirect:/authors";
		
		if (!result.hasErrors()) {
			authorService.create(author);			
		}
		
		return page;
	}
	
	@RequestMapping("/new")
	public String newAuthor(@ModelAttribute("author") Author author) {
		return "authors/new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		Author author = authorService.findById(id);
		model.addAttribute("author", author);
		
		return "authors/show.jsp";
	}
}
