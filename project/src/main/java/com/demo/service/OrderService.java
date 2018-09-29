package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.model.Address;
import com.demo.model.Order;

public interface OrderService {

	int addAddress(Address address);

	List<Address> findAddress(int id);

	int addOrder(Order order);

	List<Order> findAllOrder();

	Order findOrder(String code);

	int deleteOrderById(String code);

	int updateStatus(String r6_Order);
}
