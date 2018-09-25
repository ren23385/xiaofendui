package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.model.ShoppingCart;

@Mapper
public interface CartMapper {

	@Insert("insert into shoppingCart(book_id,price,orderNumn,sumPrice,user_id) values(#{book_id},#{price},#{orderNumn},#{sumPrice},#{user_id})")
	int insertBook(ShoppingCart cart);
	@Select("select * from shoppingCart where user_id=#{id}")
	List<ShoppingCart> findAllCart(int id);
	@Delete("delete from shoppingCart where id=#{id}")
	int delBookFromCart(int id);
	@Delete("delete from shoppingCart where user_id=#{userid}")
	int clearCart(int userid);
	@Select("select * from shoppingCart where book_id=#{id}")
	ShoppingCart findCart(int id);
	@Update("update shoppingCart set orderNumn=orderNumn+#{number},sumPrice=sumPrice+#{number}*price where book_id=#{book_id}")
	int updateCart(@Param(value = "book_id") int book_id, @Param(value = "number") int number);
	@Select("select * from shoppingCart where id=#{id}")
	ShoppingCart findCartById(int id);
	@Update("update shoppingCart set orderNumn=orderNumn+1,sumPrice=price*orderNumn where id=#{id}")
	int addCartNum(int id);
	@Update("update shoppingCart set orderNumn=orderNumn-1,sumPrice=price*orderNumn where id=#{id}")
	int reduceCartNum(int id);
}
