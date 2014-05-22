package com.stx.book.model;

/**
 * 图书model类
 * 
 * @author getan
 * 
 */
public class Book {
	// 图书编号
	private String isbn;
	// 图书标题
	private String title;
	// 图书价格
	private double price;

	public Book() {
	}

	public Book(String isbn, String title, double price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}