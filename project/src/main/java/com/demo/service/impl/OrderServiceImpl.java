package com.demo.service.impl;

import java.util.List;

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

}
