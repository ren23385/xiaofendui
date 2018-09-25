package com.demo.service;

import java.util.List;

import com.demo.model.Address;
import com.demo.model.Order;

public interface OrderService {

	int addAddress(Address address);

	List<Address> findAddress(int id);

	int addOrder(Order order);
}
