package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping(value = "/todo")
    public String get(Model model,Principal principal) {
		List<Todo> list = todoRepo.findByUseridIsAndTodoflgIs(principal.getName(), "1");
        model.addAttribute("todos",list);
        return "todo";
    }
	@PostMapping(value = "/todo",params = "insert")
    public String put(Model model,Principal principal, @RequestParam("todo") String data) {
		Todo todo = new Todo(null,data,"1",principal.getName());
		todoRepo.save(todo);
        return "redirect:/todo";
    }
	@PostMapping(value = "/todo",params = "delete")
    public String delete(Model model,Principal principal, @ModelAttribute Todo todo) {
		todoRepo.deleteByTodoid(todo.getTodoid());
        return "redirect:/todo";
    }
	@PostMapping(value = "/todo",params = "update")
    public String update(Model model,Principal principal, @ModelAttribute Todo todo) {
		todoRepo.save(todo);
        return "redirect:/todo";
    }
}

