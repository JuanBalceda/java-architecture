package com.balceda.archj.ws.model;

public class BookDTO {

	private String isbn;
	private String title;
	private String category;

	public BookDTO() {
	}

	public BookDTO(String isbn, String title, String category) {
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

}
