package com.demo.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.demo.SQLProvider.BookSqlProvider;
import com.demo.model.Book;


@Repository("bookDao")
@Mapper
public interface BookMapper {


	@Select("select * from book where 1 = 1 order by publishDate desc limit 0,7")
	List<Book> findNewBooks();
	
	@Select("select * from book where 1 = 1 and recommend = ret")
	List<Book> findTodayBooks(Boolean ret);
	
	/*@Select("select * from book where 1 = 1 and bookToallType_id = totalTypes")
	List<Book> findTotalBooks(int totalTypes);*/

	@SelectProvider(type=BookSqlProvider.class,method="createFindAllBook")
	List<Book> findAllBooks(String name, int totalType, int singleType);
}
