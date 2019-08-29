package com.example.demo.web;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	@GetMapping("/form")
	public String form() {
		return "/user/form";
	}

	@GetMapping("/{num}/form")
	public String updateUserForm(@PathVariable Long num, Model model) {
		Optional<User> user = userRepository.findById(num);
		model.addAttribute("user", user.isPresent() ? user.get() : null);
		return "/user/update_form";
	}
	
	@GetMapping("")
	public String getUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/user/list";
	}
	
	@PostMapping("")
	public String addUser(User user) {
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@PostMapping("/login")
	public String login(String uid, String password, HttpSession session) {
		System.out.println("in login");
		User user = userRepository.findByUid(uid);
		System.out.println(user);
		if(user == null || !user.getPassword().equals(password)) 
			return "redirect:/users/loginForm";
		session.setAttribute("user", user);
		System.out.println("loginSuccess");
		return "redirect:/";
	}
	
	/** 
	 * form 안에 히든 타입의 input를 넣고 name=_method, value=put 으로 하면 put메소드와 메핑된다
	 * 
	 */
	@PutMapping("/{num}")
	public String updateUser(@PathVariable long num, User userInfo) {
		User user = userRepository.findById(num).get();
		user.update(userInfo);
		userRepository.save(user);
		return "redirect:/users";
	}
//	@PostMapping("/{num}")
//	public String updateUser(@PathVariable long num, User userInfo) {
//		User user = userRepository.findById(num).get();
//		user.update(userInfo);
//		userRepository.save(user);
//		return"redirect:/users";
//	}
}
