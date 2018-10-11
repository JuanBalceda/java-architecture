package com.balceda.archj.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;

public class InsertbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Book book = new Book(isbn, title, category);
		book.insert();

		return "showbooks.do";
	}

}
