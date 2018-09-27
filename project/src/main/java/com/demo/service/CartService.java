package com.demo.service;

import java.util.List;

import com.demo.model.ShoppingCart;

public interface CartService {

	int saveCart(ShoppingCart cart);
	List<ShoppingCart>findAll(int i);
	int delBookFromCart(int id);
	int clearCart(int userid);
	ShoppingCart findCart(int id);
	int updateCartNum(int book_id, int number);
	ShoppingCart findCartById(int id);
	int addCartNum(int id);
	int reduceCartNum(int id);
	int cleaCartById(int[] arr);
}
