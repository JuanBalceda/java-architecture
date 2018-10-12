package com.balceda.archj.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public class UpdatebookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Category c = new Category();
		c.setId(category);
		Book libro = new Book(isbn, title, c);
		libro.update();
		return "Showbooks.do";
	}

}
