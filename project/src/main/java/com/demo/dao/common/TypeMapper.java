package com.demo.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.demo.model.BookSingleType;
import com.demo.model.BookToallType;

@Repository("totalTypeDao")
@Mapper
public interface TypeMapper {

	@Select("select * from booktoalltype")
	List<BookToallType> findTotalTypes();
	
	@Select("select * from booksingletype where bookToallType_id = #{totalType}")
	List<BookSingleType> findSingleTypes(int totalType);
}
