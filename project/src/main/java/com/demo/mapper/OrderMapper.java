package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demo.model.Address;
import com.demo.model.Order;

@Mapper
public interface OrderMapper {
	
	
    @Insert("insert into address(address,mobile,personName,code,user_id) values(#{address},#{mobile},#{personName},#{code},#{user_id})")
	int addAddress(Address address);
    @Select("select * from address where user_id=#{id}")
	List<Address> findAddressById(int id);
    @Insert("insert into order_from(id,totallPrice,user_id) values(#{id},#{totallPrice},#{user_id})")
	int addOrder(Order order);
	
	
	
	
	
	

}
