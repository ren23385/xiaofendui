package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Address;
import com.demo.model.OrderItem;
import com.demo.model.ShoppingCart;
import com.demo.model.User;
import com.demo.service.BookService;
import com.demo.service.CartService;
import com.demo.service.OrderService;

@Controller
public class OrderController {
	 @Autowired
	private CartService Service;
	 @Autowired
	 private BookService bookService;
	 @Autowired
	 private OrderService  orderService;
	 
	private List<Integer> listArr;
	public OrderController() {
	}
	
	 @RequestMapping(path="toAddOrderItem",method=RequestMethod.POST)
	public void setArr(@RequestParam(name="arr") Integer[] arr) {
		  
		 listArr=new ArrayList<>();
		 for (int i : arr) {
			 listArr.add(i);
		}
	}
	 
	
	
	 @RequestMapping("/toOrderItem")
	 @ResponseBody
	   public Map<String, Object> setArr2(HttpSession session) {
		  
		 
		  List<ShoppingCart> list = new ArrayList<>();
			for (int id :listArr) {
				
			ShoppingCart findCart = Service.findCartById(id);
			list.add(findCart);
			}
			double sumMoney = 0.0;
			// 根据book_id获得book信息，把其封装在shoppingCart中
			for (ShoppingCart cart : list) {
			cart.setBook(bookService.findBook(cart.getBook_id()));
				sumMoney += cart.getSumPrice();// 购物车商品总钱数

			}
			// 查询用用户收货地址
			User user = (User) session.getAttribute("user");
			List<Address>listAddress=orderService.findAddress(user.getId());

			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("sumMoney", sumMoney);
			map.put("listAddress", listAddress);
			return map;
				
	   }

	   //获得选中的购物车项

		
		
		
		
		//获取订单项
		@RequestMapping("/getOrderItem")
		public String toOrder() {
		
			return "order";

		}
		
		// 添加收货人
		
		@RequestMapping("/addAddress")         //@ModelAttribute Address：input 中name必须和类中属性一致
		public  String addAddress(@ModelAttribute Address address,HttpSession session) {
		     User user = (User) session.getAttribute("user");
			Address address2 = new Address(address.getAddress(), address.getMobile(), address.getPersonName(), address.getCode());
			address2.setUser_id(user.getId());
			int res=orderService.addAddress(address2);
			
			
			return "redirect:/getOrderItem";
		}
		
		
		@RequestMapping("/getOrderList")
		public String getOrderList() {
			
			
			
			return "orderList";
		}
		
		
		
		
		
		
		

}
