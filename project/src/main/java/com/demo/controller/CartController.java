package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

	public CartController() {
	}

	@RequestMapping("/toCart")
	public String toLogin() {
		
		return "cart";
		
	}
}
