package com.demo.model;

import java.io.Serializable;

public class BookToallType implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String bookType;
	public BookToallType() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public BookToallType(String bookType) {
		super();
		this.bookType = bookType;
	}
	@Override
	public String toString() {
		return "BookToallType [id=" + id + ", bookType=" + bookType + "]";
	}
	
	
	

}
