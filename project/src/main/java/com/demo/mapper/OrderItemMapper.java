package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.model.OrderItem;
import com.demo.model.ShoppingCart;

@Mapper
public interface OrderItemMapper {
    
	@Insert("insert into orderitem(book_id,price,sumPrice,orderNum,user_id) values(#{book_id},#{price},#{sumPrice},#{orderNumn},#{user_id})")
	int addOrderItem(ShoppingCart cart);
	@Select("select * from orderitem where user_id=#{id}")
	List<OrderItem> findAll(int id);
	
}
