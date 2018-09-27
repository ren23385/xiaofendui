package com.demo.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	public BookController() {
		super();
	}


	@RequestMapping("/bookList")
	@ResponseBody
	public Map<String, Object> showBook(@RequestParam(defaultValue = "-1", required = false) int totalType,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue="-1",required=false) int singleType) {

		
		System.out.println("++++++++========");
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
	
	//更具id展示商品
	@RequestMapping("/toProduct")
	public String toBookInfo(@RequestParam(defaultValue="1") int id,Model model) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book",book);
		return "product";
	}
	//搜索商品
	@RequestMapping("/searchWord")
	@ResponseBody
	public List<String> toSearchWord( @RequestParam(required=false) String word) {
		//Map<String,Object> map=new HashMap<>();
		List<String>list=bookService.searchProduct(word);
		System.out.println(list);
		//map.put("map", list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			
		}
		System.out.println(word+"========="+list);
		return list;
	}
	
	 //搜索到名字展示商品
		@RequestMapping("/toProduct2")
		public String toBookInfo2(@RequestParam(name="name") String name,Model model) {
			Book book = bookService.findBook(name);
			
			model.addAttribute("book",book);
			return "product";
		}
	

}
