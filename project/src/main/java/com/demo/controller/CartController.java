package com.demo.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.model.ShoppingCart;
import com.demo.model.User;
import com.demo.service.BookService;
import com.demo.service.CartService;

@Controller
public class CartController {
	
    @Autowired
	private CartService cartService;
    @Autowired
    private BookService bookService;
	public CartController() {
	}
	
	//点击加时增加数量
	@RequestMapping("/addCartNum")
	public String addNum(@RequestParam(name="id") int id) {
		int res=cartService.addCartNum(id);
		
		return "redirect:/toCart";
		
	}
	//点击加时减少数量
		@RequestMapping("/reduceCartNum")
		public String reduceNum(@RequestParam(name="id") int id) {
			int res=cartService.reduceCartNum(id);
			
			return "redirect:/toCart";
			
	}
	
   // 获得用户购物车列表
	@RequestMapping("/toCart")
	public String toFindAll(HttpSession session,Model model) {
		
		User user = (User) session.getAttribute("user");
		
		List<ShoppingCart> list = cartService.findAll(user.getId());
		 double sumMoney=0.0; 
		// 根据book_id获得book信息，把其封装在shoppingCart中
		for (ShoppingCart shoppingCart : list) {
			shoppingCart.setBook(bookService.findBook(shoppingCart.getBook_id()));
			sumMoney+=shoppingCart.getSumPrice();//购物车商品总钱数
			
		}
		
		model.addAttribute("list", list);
		model.addAttribute("sumMoney", sumMoney);
		
		
		return "cart";
		
	}
	
	// 把商品信息添加到购物车
	@RequestMapping("toAddCart")
	public String toAddBook(Model model,@RequestParam int id,@RequestParam double newPrice,@RequestParam int number,HttpSession session,@RequestParam String bookName) {
		//先判断之前购物车是否有该商品了 
		ShoppingCart cart=cartService.findCart(id);
		if(cart!=null) {
			int update=cartService.updateCartNum(cart.getBook_id(),number);
			
			if(update>0)
			{
				model.addAttribute("bookName", bookName);
				
				return "addsuccess";
			}
		}
		
		
		ShoppingCart shoppingCart = new ShoppingCart(id, newPrice, number);
		
		
		shoppingCart.setSumPrice(newPrice*number);
		User user = (User) session.getAttribute("user");
		shoppingCart.setUser_id(user.getId());
		
		int saveCart = cartService.saveCart(shoppingCart);
		if(saveCart>0)
		{
			
			model.addAttribute("bookName", bookName);
			return "addsuccess";
		}
		
		return "";
		
	}
	
	
	// 从购物车中删除单个商品
	@RequestMapping("/delBookFromCart")
	public String delBookFromCart(@RequestParam int id) {
		int delBookFromCart = cartService.delBookFromCart(id);
		if(delBookFromCart>0) {
			
			
			return "redirect:/toCart";
		}
		return "redirect:/toCart";
		
	}
	// 清空购物车
	
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session) {
		User user = (User) session.getAttribute("user");
		int clearCart = cartService.clearCart(user.getId());
		if(clearCart>0) {
			
			
			return "cart";
		}
		return "redirect:/toCart";
		
	}
	
	
	
	
}
