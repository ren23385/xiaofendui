package com.demo.service.front;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Book;
import com.github.pagehelper.PageInfo;

public interface BookService {

	@Transactional(readOnly=true)
	List<Book> findAllNewBooks();
	
	@Transactional(readOnly=true)
	List<Book> findTodayBooks(Boolean ret);
	
	@Transactional(readOnly=true)
	List<Book> findAllBooks(int totalBookType);

	@Transactional
	PageInfo<Book> findAllBooks(int pageNo, String name, int totalType, int singleType);
}
