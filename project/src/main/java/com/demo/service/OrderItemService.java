package com.demo.service;

import java.util.List;

import com.demo.model.OrderItem;

public interface OrderItemService {

	void addOrderItem(int[] arr, String orderCode);

	List<OrderItem> findAll(String string);

	int deleteOrderItem(String code);
}
