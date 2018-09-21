package com.demo.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.model.Book;
import com.demo.model.BookSingleType;
import com.demo.model.BookToallType;
import com.demo.service.front.BookService;
import com.github.pagehelper.PageInfo;

@Controller
public class BookController {

	@Autowired
	@Qualifier(value = "bookService")
	private BookService bookService;
	
	int pageNoo = 1;
	
	Book book = new Book();
	BookSingleType bookSingleType = new BookSingleType();
	BookToallType toallType = new BookToallType();
	
	@SuppressWarnings("null")
	@RequestMapping("/toBookList")
	public String toBookList(@RequestParam(defaultValue = "-1", required = false) int totalType,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue="-1",required=false) int singleType) {
		
		if(totalType!= -1) {
			toallType.setId(totalType);
		}
		
		if(singleType!= -1) {
			bookSingleType.setId(singleType);
		}else {
			bookSingleType.setId(-1);
		}
		
		
		if(name != null || !name.isEmpty()) {
			book.setBookName(name);
		}else {
			book.setBookName("");
		}
		
		if(pageNo > 0) {
			pageNoo = pageNo;
		}
		
				
		return "front/bookList";
	}
	
	
	@RequestMapping("/bookList")
	@ResponseBody
	public Map<String, Object> showBook(@RequestParam(defaultValue = "-1", required = false) int totalType,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue="-1",required=false) int singleType) {

		Map<String, Object> result = new HashMap<>();
		
		if(singleType != -1) {
			
			bookSingleType.setId(singleType);
		}
		
		if(totalType != -1) {
			toallType.setId(totalType);
		}
		
		System.out.println(bookSingleType.getId()+"+++++++"+toallType.getId()+"++++++++++++++++++");

		PageInfo<Book> pageInfo = bookService.findAllBooks(pageNoo, book.getBookName(), toallType.getId(),bookSingleType.getId());

		result.put("pageInfo", pageInfo);
		
		return result;
	}
	
	@RequestMapping("/findAllNewBooks")
	@ResponseBody
	public Map<String, Object> findAllNewBooks(){
		List<Book> books = bookService.findAllNewBooks();
		Map<String, Object> result = new HashMap<>();
		result.put("newBooks", books);
		
		return result;
	}
	
	@RequestMapping("/findTodayBooks")
	@ResponseBody
	public  Map<String, Object> findNewBooks(){
		List<Book> books = bookService.findAllNewBooks();
		Map<String, Object> result = new HashMap<>();
		result.put("todayBooks", books);
		return result;
	}

}
