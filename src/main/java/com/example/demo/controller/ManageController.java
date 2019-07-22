package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@PostMapping(value = "/manage",params = "update")
    public String update(RedirectAttributes attributes,Principal principal, @RequestParam("password") String password,@RequestParam("password-new") String password_new,@RequestParam("password-retype") String password_retype) {
		
		String result = "";
		System.out.println(principal.getName() + " : " + password);
		if(userRepo.countByUseridIsAndPasswordIs(principal.getName(),password) == 1) {
			if(password_new.equals(password_retype)) {
				userRepo.updateByUserid(password_new, principal.getName());
				result = "更新しました。";
			}else {
				result = "再入力されたパスワードが違います";
			}
		}else {
			result = "現在のパスワードが違います";
			attributes.addFlashAttribute("result",result);
		}
        return "redirect:/manage";

    }
	@PostMapping(value = "/manage",params = "delete")
    public String delete(RedirectAttributes attributes,Principal principal) {
		userRepo.deleteByUserid(principal.getName());
        return "redirect:/login";
    }
}

