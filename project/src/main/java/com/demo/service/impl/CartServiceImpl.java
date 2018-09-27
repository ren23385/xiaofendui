package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.CartMapper;
import com.demo.model.ShoppingCart;
import com.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
	private CartMapper cartMapper;
	public CartServiceImpl() {
	}

	@Override
	public int saveCart(ShoppingCart cart) {
		return cartMapper.insertBook(cart);
	}

	@Override
	public List<ShoppingCart> findAll(int id) {
		return cartMapper.findAllCart(id);
	}

	@Override
	public int delBookFromCart(int id) {

		return cartMapper.delBookFromCart(id);
	}

	@Override
	public int clearCart(int userid) {
		return cartMapper.clearCart(userid);
	}

	@Override
	public ShoppingCart findCart(int id) {
		return cartMapper.findCart(id);
	}

	@Override
	public int updateCartNum(int book_id,int number) {
		return  cartMapper.updateCart(book_id,number);
	}

	@Override
	public ShoppingCart findCartById(int id) {
		
		return cartMapper.findCartById(id);
	}

	@Override
	public int addCartNum(int id) {
		return cartMapper.addCartNum(id);
	}

	@Override
	public int reduceCartNum(int id) {
		return cartMapper.reduceCartNum(id);
	}

	@Override
	public int cleaCartById(int[] arr) {
		int delBookFromCart = 0;
		for (int i : arr) {
			
			
			 delBookFromCart = cartMapper.delBookFromCart(i);
		}
		
		return delBookFromCart;
	}

}
