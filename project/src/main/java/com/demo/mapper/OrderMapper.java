package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.demo.model.Address;
import com.demo.model.Order;

@Mapper
public interface OrderMapper {
	
	
    @Insert("insert into address(address,mobile,personName,code,user_id) values(#{address},#{mobile},#{personName},#{code},#{user_id})")
	int addAddress(Address address);
    @Select("select * from address where user_id=#{id}")
	List<Address> findAddressById(int id);
    @Insert("insert into order_from(id,totallPrice,user_id,addressId) values(#{id},#{totallPrice},#{user_id},#{addressId})")
	int addOrder(Order order);
    @Select("select * from order_from where user_id=#{i}")
	List<Order> findAllOrder(int i);
    @Select("select * from order_from where id=#{code}")
	Order findOrder(String code);
    @Delete("delete from order_from where id=#{code}")
	int deleteOrder(String code);
    @Update("update order_from set orderStatus=1 where id=#{r6_Order}")
	int updateStatus(String r6_Order);
	
	
	
	
	
	

}
