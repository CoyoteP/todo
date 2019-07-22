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

@Controller
public class TodoController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TodoRepository todoRepo;
	
	@GetMapping("/todo")
    public String get(Model model,Principal principal) {
		List<Todo> list = todoRepo.findByUseridIs(principal.getName());
        model.addAttribute("messages", "party boy");
        model.addAttribute("todos",list);
        return "todo";
    }
	@PostMapping("/todo/put")
    public String put(Model model,Principal principal, @RequestParam("todo") String data) {
		Todo todo = new Todo(null,data,"1","admin");
		todoRepo.save(todo);
        return "redirect:/todo";
    }
}

