package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.TodoRepository;
import com.example.demo.UserRepository;
import com.example.demo.model.Todo;
import com.example.demo.model.User;

@Controller
public class ManageController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TodoRepository todoRepo;
	
	@GetMapping("/manage")
    public String get(Model model,Principal principal) {
        return "manage";
    }
	@PostMapping("/manage/update")
    public String put(Model model,Principal principal, @RequestParam("password") String password) {
		int result = userRepo.updateByUserid(password, principal.getName());
		model.addAttribute("result",result);
        return "manage";
    }
}

