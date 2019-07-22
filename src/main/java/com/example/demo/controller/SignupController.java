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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.TodoRepository;
import com.example.demo.UserRepository;
import com.example.demo.model.User;

@Controller
public class SignupController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	TodoRepository todoRepo;

	@GetMapping("/signup")
	public String get(Model model, Principal principal) {
		return "signup";
	}

	@PostMapping("/signup")
	public String post(Model model, @RequestParam("userid") String userid, @RequestParam("password") String password,
			@RequestParam("password-retype") String password_retype) {
		String result = "";
		if (password.equals(password_retype)) {
			if (userRepo.countByUserid(userid) == 0) {
				User user = new User(userid, password);
				userRepo.save(user);
				return "login";
			}else {
				result = "登録済みのuseridです";
			}
			
		}else {
			result = "パスワードが異なります";
		}
		model.addAttribute("result",result);
		return "signup";
	}
}
