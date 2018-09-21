package com.demo.service.impl.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.dao.common.BookMapper;
import com.demo.model.Book;
import com.demo.service.front.BookService;
import com.demo.util.PageConstent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookDao")
	private BookMapper bookMapper;

	
	/*
	 *	 最新上架
	 */
	@Override
	public List<Book> findAllNewBooks() {
		// TODO Auto-generated method stub
		return bookMapper.findNewBooks();
	}

	/*
	 *	查找今日推荐 
	 */

	@Override
	public List<Book> findTodayBooks(Boolean ret) {
		// TODO Auto-generated method stub
		return bookMapper.findTodayBooks(ret);
	}



	/*
	 *	根据大类型找到相应的书籍 
	 */
	
	@Override
	public List<Book> findAllBooks(int totalBookType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Book> findAllBooks(int pageNo, String name, int totalType, int singleType) {

		PageHelper.offsetPage((pageNo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		
		/*System.out.println(totalType+"22222222222222222"+singleType);*/
		
		List<Book> ls  = bookMapper.findAllBooks(name,totalType,singleType);
		PageInfo<Book> pageInfo = new PageInfo<>(ls);
		
		System.out.println(pageInfo);
		
		return pageInfo;
	}
	
	
	
	

}
