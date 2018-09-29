package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserMapper userMapper;
	@Override
	public User findUser(String name, String password) {
		return userMapper.findUser(name, password);
	}
	@Override
	public Boolean findUserByName(String name) {
		User user=userMapper.findUserByName(name);
		if(user==null) {
			return false;
		}
		return true;		
	}
	@Override
	public int AddUser(User user) {
		return userMapper.adduser(user);
	}


}
