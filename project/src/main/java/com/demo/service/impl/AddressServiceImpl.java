package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.AddressMapper;
import com.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
	private AddressMapper addressMapper;
	public AddressServiceImpl() {
	}

	@Override
	public int deleteAddress(int id) {
		return addressMapper.deleteAddress(id);
	}

}
