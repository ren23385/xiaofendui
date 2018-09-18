package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	public OrderController() {
	}

	@RequestMapping("/toOrder")
	public String toLogin() {
		
		return "order";
		
	}
}
