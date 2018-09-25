package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demo.model.Book;

@Mapper
public interface BookMapper {
	// 展示单个书籍信息
	@Select("select * from book where id=#{id}")
	Book findBookById(int id);
	

}
