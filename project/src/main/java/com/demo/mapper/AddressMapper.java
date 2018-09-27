package com.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {

	@Delete("delete from address where id=#{id}")
	int deleteAddress(int id);
}
