package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String doLogin(@RequestParam String vode, @RequestParam String name, @RequestParam String password,
			HttpSession session, Model model) {
		System.out.println(name + "------" + password + "-----" + vode);

		String Vodeattribute = (String) session.getAttribute(ValidateController.serverCode);
		if (!vode.equalsIgnoreCase(Vodeattribute)) {

			model.addAttribute("msg", "验证码输入错误");
			return "login";
		}

		User admin = userService.findUser(name.trim(), password.trim());
		if (admin == null) {

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
	// 注册

	@RequestMapping("/doRegister")
	@ResponseBody
	public Map<String, Object> doRegister(@ModelAttribute User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("-----"+user);
		Boolean b = userService.findUserByName(user.getName());
		if (b) {
			map.put("success", false);
			map.put("msg", "该用户已注册，请直接登录或注册新用户");
			return map;
		}
		int ret = userService.AddUser(user);
		map.put("success", true);
		map.put("url", "/");
       
		return map;
	}

	@RequestMapping("/toLogout")
	public String toLogout(HttpSession session) {

		session.removeAttribute("user");

		return "redirect:/";
	}

}
