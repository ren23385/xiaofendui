package com.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.OrderMapper;
import com.demo.model.Address;
import com.demo.model.Order;
import com.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderMapper orderMapper;
	public OrderServiceImpl() {
	}

	@Override
	public int addAddress(Address address) {
		return orderMapper.addAddress(address);
	}

	@Override
	public List<Address> findAddress(int id) {
		return orderMapper.findAddressById(id);
	}

	@Override
	public int addOrder(Order order) {
		return orderMapper.addOrder(order);
	}

	@Override
	public List<Order> findAllOrder(int i) {
		return orderMapper.findAllOrder(i);
	}

	@Override
	public Order findOrder(String code) {
		return orderMapper.findOrder(code);
	}

	@Override
	public int deleteOrderById(String code) {
		return orderMapper.deleteOrder(code);
	}

	@Override
	public int updateStatus(String r6_Order) {
		return orderMapper.updateStatus(r6_Order);
	}

}
