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

	@RequestMapping("/helloworld")
	public String welcome(String name, int age, Model model) {
//	public ModelAndView welcome(String name, int age, Model model) {
//		ModelAndView mv = new ModelAndView("welcome");
//		mv.addObject("name", name);
//		return mv;
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		System.out.println("welcome "+name+", age is "+age);
		return "welcome";
	}
}
