package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/signup")
    public String get(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!! how are you?");
        model.addAttribute("menu", "home servlet model");
        List<User> list=userRepository.findAll();
        model.addAttribute("list", list);
        for(User user: list) {
        	System.out.println(user.getUserid());
        }
        return "signup";
    }
	
	@PostMapping("/signup")
    public String post(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!! how are you?");
        model.addAttribute("menu", "home servlet model");
        List<User> list=userRepository.findAll();
        model.addAttribute("users", list);
        for(User user: list) {
        	System.out.println(user.getUserid());
        }
        return "signup";
    }
}


