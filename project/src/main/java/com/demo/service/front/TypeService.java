package com.demo.service.front;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.demo.model.BookSingleType;
import com.demo.model.BookToallType;

public interface TypeService {

	@Transactional(readOnly=true)
	List<BookToallType> findTotalTypes();
	
	@Transactional(readOnly=true)
	List<BookSingleType> findSingleTypes(int totalType);
}
