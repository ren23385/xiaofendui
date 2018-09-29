package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.mapper.CartMapper;
import com.demo.model.Order;
import com.demo.model.OrderItem;
import com.demo.model.User;
import com.demo.service.BookService;
import com.demo.service.CartService;
import com.demo.service.OrderItemService;
import com.demo.service.OrderService;

@Controller
public class OrderItemController {
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private OrderService orderService;
	 @Autowired
	 private BookService bookService;
	 @Autowired
   private CartService cartService;
	 
	private double sumMoney;
	private String orderCode;

	public OrderItemController() {
	}

	// 把在订单中的订单项插入数据库
	@RequestMapping("/toAddOrder")
	@ResponseBody
	public  void addOrderItem(@RequestParam(name = "arr") int[] arr,
			@RequestParam(name = "sumMoney", required = false) double sumMoney,@RequestParam(name="addressId") int addressId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String id = user.getId() + "";
		String currentTimeMillis = System.currentTimeMillis() + "";
		// 订单号
		String orderCode = id + currentTimeMillis;
		this.orderCode=orderCode;
		this.sumMoney=sumMoney;
		// 1插入订单项
		orderItemService.addOrderItem(arr,orderCode);
		// user_id
		int id2 = user.getId();
		Order order = new Order(orderCode, sumMoney, id2,addressId);
		//2 插入订单
		int res = orderService.addOrder(order);
		//3 清除购物车中的订单项（添加的订单项清除）
		int ret=cartService.cleaCartById(arr);
		

	}

	// 进入支付页面
	@RequestMapping("/toPayMoney")
	public String getOrder(Model model) {
		
		model.addAttribute("orderCode", this.orderCode);
		model.addAttribute("sumMoney", this.sumMoney);

		return "paymoney";
	}
	// 进入支付页面
	@RequestMapping("/toPayMoney2")
	public String getOrder(Model model,@RequestParam(required=false,name="code") String code) {
		//根据订单号查询订单总额
		Order order=orderService.findOrder(code);
		model.addAttribute("orderCode", code);
		model.addAttribute("sumMoney",order.getTotallPrice());

		return "paymoney";
	}
	
	//查看订单页面
	@RequestMapping("/toOrderList")
	public String getOrderList() {
		
		
		
		return "orderList";
	}
	
	@RequestMapping("/getOrderList")
    @ResponseBody
	public Map<String,Object> getOrderItemList( HttpSession session) {
		User user = (User) session.getAttribute("user");

		Map<String,Object> map=new HashMap<>();
		List<Order>list=orderService.findAllOrder(user.getId());
		for (Order order : list) {
		   	
			List<OrderItem>orderItemList=orderItemService.findAll(order.getId());
			order.setList(orderItemList);
			for (OrderItem item: orderItemList) {
				item.setBook(bookService.findBook(item.getBook_id()));
			}
			
		}
		map.put("list", list);
		
		return map;
		
	}
	
	// 取消订单
	@RequestMapping("/deleteOrder")
	public String deleteOrder(@RequestParam String code) {
		
		//1 删除订单
		int res=orderService.deleteOrderById(code);
		// 2 删除订单中订单项
		int ret=orderItemService.deleteOrderItem(code);
		// 3都执行成功才能取消‘
		if(res>0&&ret>0)
		{
			
			return "redirect:/toOrderList";
			
		}
		return "";
	}
	
	

}
