package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.TodoRepository;
import com.example.demo.UserRepository;
import com.example.demo.model.Todo;
import com.example.demo.model.User;

@Controller
public class RegisterController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	TodoRepository todoRepo;

	@GetMapping("/register")
	public String get(Model model, Principal principal) {
		return "register";
	}

	@PostMapping("/register")
	public String post(Model model, @ModelAttribute User user) {
		String result = "";
		if (userRepo.countByUserid(user.getUserid()) == 0) {
			userRepo.save(user);
			return "login";
		} else {
			result = "登録済みのユーザIDです";
		}

		model.addAttribute("result", result);
		return "register";
	}
}
