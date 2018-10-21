package com.balceda.archj.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.interfaces.BookService;
import com.balceda.archj.service.interfaces.CategoryService;

@ManagedBean(name = "bookMB")
@SessionScoped
public class BookMB {

	@ManagedProperty("#{bookService}")
	private BookService bookService;

	@ManagedProperty("#{categoryService}")
	private CategoryService categoryService;

	private String isbn;
	private String title;
	private String category;

	private List<Book> books;
	private List<Category> categories;

	public BookMB() {
	}

	@PostConstruct
	public void init() {
		books = getBookService().selectAll();
		categories = getCategoryService().selectAll();
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void insert(ActionEvent event) {
		getBookService().insert(new Book(isbn, title, new Category(category)));
		setBooks(getBookService().selectAll());
		category = "0";
	}

	public void delete(String id) {
		getBookService().delete(new Book(id));
		setBooks(getBookService().selectAll());
	}

	public void edit(String id) {
		Book b = getBookService().selectById(id);

		this.isbn = b.getIsbn();
		this.title = b.getTitle();
		this.category = b.getCategory().getId();
	}

	public void update(ActionEvent event) {
		getBookService().update(new Book(isbn, title, new Category(category)));
		setBooks(getBookService().selectAll());
		category = "0";
	}

	public void newbook() {
		isbn = "";
		title = "";
		category = "";
	}

	public void filter(ValueChangeEvent event) {
		int id = Integer.parseInt(event.getComponent().getAttributes().get("value").toString());
		System.out.println("Category id: " + id);
		if (id != 0) {
			setBooks(getBookService().selectByCategory(new Category(String.valueOf(id))));
		} else {
			setBooks(getBookService().selectAll());
		}
	}

}
