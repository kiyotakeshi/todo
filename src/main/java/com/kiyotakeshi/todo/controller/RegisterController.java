package com.kiyotakeshi.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "register")
public class RegisterController {

	@GetMapping
	public String getIndex(Model model) {
		return "register";
	}

}
