package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

//	@GetMapping("/create")
	@PostMapping("/create")
	public String create(User user) {
		System.out.println("in create");
		System.out.println(user);
		return "index";
	}
}
