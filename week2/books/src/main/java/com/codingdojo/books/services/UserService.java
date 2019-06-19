package com.codingdojo.books.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.books.models.User;
import com.codingdojo.books.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email).orElse(null);
	}
	
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User register(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
//		User user2 = new User();
//		
//		user2.setPassword("password");
		
		return userRepo.save(user);
	}
	
	public boolean validatePassword(String email, String password) {
		User user = findByEmail(email);
		
		if (user == null) {
			return false;
		}
		
		return validatePassword(user, password);
	}
	
	public boolean validatePassword(User user, String password) {
		return BCrypt.checkpw(password, user.getPassword());
	}
}
