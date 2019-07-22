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
    public String get(Model model,Principal principal) {
        model.addAttribute("message", "Hello Thymeleaf!! how are you?");
        model.addAttribute("menu", principal.getName());
        List<User> list=userRepo.findAll();
        model.addAttribute("list", list);
        for(User a: list) {
        	System.out.println(a.getUserid());
        }
        return "signup";
    }
	
	@PostMapping("/signup")
    public String post(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!! how are you?");
        model.addAttribute("menu", "home servlet model");
        List<User> list=userRepo.findAll();
        model.addAttribute("users", list);
        for(User user: list) {
        	System.out.println(user.getUserid());
        }
        return "signup";
    }
}


