package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
	@GetMapping("/todo")
    public String login(Model model) {
        model.addAttribute("messages", "party boy");

        return "todo";
    }
}

