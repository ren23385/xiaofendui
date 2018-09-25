package com.demo.service;

import com.demo.model.User;

public interface UserService {

	User findUser(String name,String password);
}
