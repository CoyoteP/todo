package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
    public String hello(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!! how are you?");
        model.addAttribute("menu", "home servlet model");

        return "index";
    }
}
