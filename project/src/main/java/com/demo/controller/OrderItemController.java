package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Order;
import com.demo.model.User;
import com.demo.service.OrderItemService;
import com.demo.service.OrderService;

@Controller
public class OrderItemController {
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private OrderService orderService;

	private double sumMoney;
	private String orderCode;

	public OrderItemController() {
	}

	// 把在订单中的订单项插入数据库
	@RequestMapping("/toAddOrder")
	public  void addOrderItem(@RequestParam(name = "arr") int[] arr,
			@RequestParam(name = "sumMoney", required = false) double sumMoney, HttpSession session) {
		// 插入订单项
		orderItemService.addOrderItem(arr);
		User user = (User) session.getAttribute("user");
		String id = user.getId() + "";
		String currentTimeMillis = System.currentTimeMillis() + "";
		// 订单号
		String orderCode = id + currentTimeMillis;
		this.orderCode=orderCode;
		this.sumMoney=sumMoney;
		// user_id
		int id2 = user.getId();
		Order order = new Order(orderCode, sumMoney, id2);
		int res = orderService.addOrder(order);
		

	}

	// 进入支付页面
	@RequestMapping("/toPayMoney")
	public String getOrder(Model model) {
		
		model.addAttribute("orderCode", this.orderCode);
		model.addAttribute("sumMoney", this.sumMoney);
		System.out.println(this.orderCode+"======");

		return "paymoney";
	}

}
