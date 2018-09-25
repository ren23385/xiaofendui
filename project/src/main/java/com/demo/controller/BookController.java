package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.model.Book;
import com.demo.service.BookService;

@Controller
public class BookController {
    @Autowired
	private BookService bookService;
	
	public BookController() {
	}
	
	@RequestMapping("/toProduct")
	public String toBookInfo(@RequestParam(defaultValue="1") int id,Model model) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book",book);
		return "product";
	}

	/*@RequestMapping("/getBookInfo")
	@ResponseBody
	public Map<String,Object> toLogin(@RequestParam(defaultValue="1") int id) {
       
		Book book = bookService.findBook(id);
		Map<String,Object> map = new HashMap<>();
		map.put("book",book);
		
		return map;

	}*/
	



	
}
