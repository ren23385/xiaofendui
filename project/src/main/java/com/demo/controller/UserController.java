package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	public UserController() {
	}

	@RequestMapping("/toLogin")
	public String toLogin() {

		return "login";

	}



	@RequestMapping("/toRegister")
	public String toRegister() {

		return "register";

	}
}
