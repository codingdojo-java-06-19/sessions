package com.codingdojo.books.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.books.models.User;
import com.codingdojo.books.services.UserService;
import com.codingdojo.books.validator.UserValidator;

@Controller
public class HomeController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public HomeController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
//	@GetMapping("/")
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);
		System.out.println(result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		userService.register(user);
		
		return "redirect:/books";
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		if (!userService.validatePassword(email, password)) {
			return "redirect:/";
		}
		
		User user = userService.findByEmail(email);
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
	}
	
//	@PutMapping()
//	@DeleteMapping()
}
