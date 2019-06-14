package com.codingdojo.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.Author;
import com.codingdojo.books.repositories.AuthorRepository;

@Service
public class AuthorService {
	private final AuthorRepository authorRepo;
	
	public AuthorService(AuthorRepository repo) {
		this.authorRepo = repo;
	}
	
	public List<Author> findAll() {
		return authorRepo.findAll();
	}
	
	public Author findById(Long id) {
		return authorRepo.findById(id).orElse(null);
//		Optional<Author> author = authorRepo.findById(id);
//		if (author.isPresent()) {
//			return author.get();
//		}
//		
//		return null;
	}
	
	public Author create(Author author) {
		return authorRepo.save(author);
	}
}
