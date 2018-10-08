package com.balceda.archj.app.model;

import java.util.List;

import com.balceda.archj.app.util.DatabaseHelper;

public class Book {

	private String isbn;
	private String title;
	private String category;

	public Book() {
	}

	public Book(String isbn, String title, String category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.category = category;
	}

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

	public void insert() {
		String sqlQuery = "insert into books (isbn, title, category) values('" + this.isbn + "', '" + this.title
				+ "', '" + this.category + "')";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		db.update(sqlQuery);
	}

	public static List<Book> selectAll() {
		String sqlQuery = "select * from books";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		List<Book> list = db.select(sqlQuery, Book.class);
		return list;
	}

	public static List<String> selectAllCategories() {
		String sqlQuery = "select distinct(category) from books";
		DatabaseHelper<String> db = new DatabaseHelper<String>();
		List<String> list = db.select(sqlQuery, String.class);
		return list;
	}

	public static Book selectById(String isbn) {
		String sqlQuery = "select * from books where isbn='" + isbn + "'";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		List<Book> list = db.select(sqlQuery, Book.class);
		return list.get(0);
	}

	public static List<Book> selectByCategory(String category) {
		String sqlQuery = "select * from books where category='" + category + "'";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		List<Book> list = db.select(sqlQuery, Book.class);
		return list;
	}

	public void update() {
		String sqlQuery = "update books set title='" + this.title + "', category='" + this.category + "' where isbn='"
				+ this.isbn + "'";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		db.update(sqlQuery);
	}

	public void delete() {
		String sqlQuery = "delete from books where isbn='" + this.isbn + "'";
		DatabaseHelper<Book> db = new DatabaseHelper<Book>();
		db.update(sqlQuery);
	}

}
