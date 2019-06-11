package com.codingdojo.hello.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		System.out.println("In Home Controller");
		
		Integer age = (Integer) session.getAttribute("age");
		String name = (String) session.getAttribute("name");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		System.out.println(name + " " + age);
		
		return "index.jsp";
	}
	
	
	@RequestMapping(value="/posted", method=RequestMethod.POST)
	public String postTo(@RequestParam("name") String content, @RequestParam("age") Integer age, HttpSession session) {
		System.out.println("posting content ::" + content + age);
		

		
		session.setAttribute("name", content);
		session.setAttribute("age", age);
		
		return "redirect:/";
	}
}
