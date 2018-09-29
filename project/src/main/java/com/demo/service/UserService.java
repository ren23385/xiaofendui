package com.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.model.User;

public interface UserService {

	User findUser(String name,String password);

	@Transactional(readOnly=true)
	Boolean findUserByName(String name);
	@Transactional
	int AddUser(User user);

}
