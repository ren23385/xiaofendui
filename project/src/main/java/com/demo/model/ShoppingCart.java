package com.demo.model;

import java.io.Serializable;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int  book_id;
	private double price;
	private int orderNumn;
	private double sumPrice;
	private int user_id;
	private Book book;
	public ShoppingCart() {
		
	}
	
	
	
	public ShoppingCart( int  book_id, double price, int orderNumn) {
		super();
		this.book_id = book_id;
		this.price = price;
		this.orderNumn = orderNumn;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOrderNumn() {
		return orderNumn;
	}
	public void setOrderNumn(int orderNumn) {
		this.orderNumn = orderNumn;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", orderName=" + book_id + ", price=" + price + ", orderNumn=" + orderNumn
				+ ", sumPrice=" + sumPrice + ", user_id=" + user_id + "]";
	}
	
	
}
