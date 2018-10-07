package com.balceda.archj.app.model;


import java.util.List;

import com.balceda.archj.app.util.DatabaseHelper;

public class Book {

	private String isbn;
	private String title;
	private String category;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Book(String isbn, String title, String category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.category = category;
	}

	public static List<String> selectAllCategories() {
		String sqlQuery = "select distinct(category) from books";
		DatabaseHelper<String> db = new DatabaseHelper<String>();
		List<String> list = db.select(sqlQuery, String.class);
		return list;
	}

	public void insert() {
		String sqlQuery = "insert into books (isbn, title, category) values('" + this.isbn + "', '" + this.title + "', '"
				+ this.category + "')";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		db.update(sqlQuery);
	}

	public static List<Book> selectAll() {
		String sqlQuery = "select * from books";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		List<Book> list = db.select(sqlQuery, Book.class);
		return list;
	}
}
