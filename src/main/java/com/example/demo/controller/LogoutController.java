package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	@GetMapping("/logout")
    public String login(Model model) {
        model.addAttribute("messages", "party boy");

        return "login";
    }
}