package com.balceda.archj.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.dao.implementation.jpa.BookDAOImpl;
import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public class InsertbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDAOImpl bookDAO = new BookDAOImpl();

		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Category c = new Category();
		c.setId(category);
		Book book = new Book(isbn, title, c);
		bookDAO.insert(book);

		return "Showbooks.do";
	}

}
