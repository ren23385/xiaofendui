package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.CartMapper;
import com.demo.mapper.OrderItemMapper;
import com.demo.model.OrderItem;
import com.demo.model.ShoppingCart;
import com.demo.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
	private CartMapper cartMapper;

	public OrderItemServiceImpl() {
	}

	@Override
	public void addOrderItem(int[] arr) {
		for (int id : arr) {
			
			ShoppingCart cart = cartMapper.findCartById(id);
				
				int addOrderItem = orderItemMapper.addOrderItem(cart);
			
			
		}
		
	}

	@Override
	public List<OrderItem> findAll(int id) {
		
		return orderItemMapper.findAll(id);
	}

}
