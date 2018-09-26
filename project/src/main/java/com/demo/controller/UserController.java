package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.utils.ValidateController;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {
	}

	@RequestMapping("/toLogin")
	public String toLogin() {

		return "login";

	}
	// 登陆

	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String vode,@RequestParam String name,@RequestParam String password,HttpSession session,Model model) {
		String Vodeattribute = (String) session.getAttribute(ValidateController.serverCode);
		if(!vode.equalsIgnoreCase(Vodeattribute)) {
			
			model.addAttribute("msg", "验证码输入错误");
			return "login";
		}
	
		
		User admin = userService.findUser(name.trim(), password.trim());
		if(admin==null) {
		
		model.addAttribute("msg", "用户名或密码错误");
		return "login";	
		}
		session.setAttribute("user", admin);
		return "index";

	}

	@RequestMapping("/toRegister")
	public String toRegister() {

		return "register";

	}
}
