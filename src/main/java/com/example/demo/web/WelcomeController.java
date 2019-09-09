package com.example.demo.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@ComponentScan(basePackages = {"com.example.demo.controller"})
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "/index";
	}
}
