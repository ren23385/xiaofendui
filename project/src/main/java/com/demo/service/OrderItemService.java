package com.demo.service;

import java.util.List;

import com.demo.model.OrderItem;

public interface OrderItemService {

	void addOrderItem(int[] arr);

	List<OrderItem> findAll(int id);
}
