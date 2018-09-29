package com.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.model.User;

@Mapper
public interface UserMapper {
    
	@Select("select * from user where name=#{name} and password=#{password}")
	User findUser(@Param(value = "name") String name,@Param(value = "password") String password);
	@Select("select * from user where name=#{name}")
	User findUserByName(String name);
	@Insert("insert into user(name,password) values(#{name},#{password})")
	int adduser(User user);

	
}
