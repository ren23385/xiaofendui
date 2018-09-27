package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.model.OrderItem;
import com.demo.model.ShoppingCart;

@Mapper
public interface OrderItemMapper {
    
	@Insert("insert into orderitem(book_id,price,sumPrice,orderNum,user_id,order_id) values(#{book_id},#{price},#{sumPrice},#{orderNumn},#{user_id},#{order_id})")
	int addOrderItem(ShoppingCart cart);
	@Select("select * from orderitem where order_id=#{id}")
	List<OrderItem> findAll(String id);
	@Delete("delete  from orderitem where order_id=#{code}")
	int deleteOrderItem(String code);
	
}
