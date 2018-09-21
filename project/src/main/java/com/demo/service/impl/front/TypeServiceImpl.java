package com.demo.service.impl.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.dao.common.TypeMapper;
import com.demo.model.BookSingleType;
import com.demo.model.BookToallType;
import com.demo.service.front.TypeService;

@Service("totalTypes")
public class TypeServiceImpl implements TypeService {

	@Autowired
	@Qualifier("totalTypeDao")
	private TypeMapper typeMapper;
	
	
	/**
	 * 	获取所有大类型
	 */
	@Override
	public List<BookToallType> findTotalTypes() {
		// TODO Auto-generated method stub
		return typeMapper.findTotalTypes();
	}

	/**
	 * 	通过大类型获取大类型下的小类型
	 */

	@Override
	public List<BookSingleType> findSingleTypes(int totalType) {
		// TODO Auto-generated method stub
		return typeMapper.findSingleTypes(totalType);
	}

}
