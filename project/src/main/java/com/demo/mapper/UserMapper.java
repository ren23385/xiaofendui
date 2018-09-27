package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.model.User;

@Mapper
public interface UserMapper {
    
	@Select("select * from user where name=#{name} and password=#{password}")
	User findUser(@Param(value = "name") String name,@Param(value = "password") String password);
	
	
}
