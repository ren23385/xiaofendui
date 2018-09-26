package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.BookMapper;
import com.demo.model.Book;
import com.demo.service.BookService;

@Service("service")
public class BookServiceImpl implements BookService {
@Autowired	
 private BookMapper bookMapper;
	
	public BookServiceImpl() {
	}

	@Override
	public Book findBook(int id) {
		return bookMapper.findBookById(id);
	}

}
