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
import com.example.demo.model.TodoForm;

@Controller
public class TodoController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	TodoRepository todoRepo;

	@GetMapping(value = "/todo")
	public String get(TodoForm form, Model model, Principal principal) {
		List<Todo> list = todoRepo.findByUseridIs(principal.getName());
		model.addAttribute("todos", list);
		return "todo";
	}

	@PostMapping(value = "/todo", params = "insert")
	public String put(Model model, Principal principal, @RequestParam("todo") String data) {
		Todo todo = new Todo(null, data, principal.getName());
		todoRepo.save(todo);
		return "redirect:/todo";
	}

	@PostMapping(value = "/todo", params = "delete")
	public String delete(Model model, Principal principal,
			@ModelAttribute TodoForm todoForm) {
		if (todoForm != null) {
			for (Integer i : todoForm.getList()) {
				todoRepo.deleteByTodoid(i);
			}
		}
		return "redirect:/todo";
	}

	@PostMapping(value = "/todo", params = "update")
	public String update(Model model, Principal principal, @ModelAttribute Todo todo) {
		todoRepo.save(todo);
		return "redirect:/todo";
	}
}
