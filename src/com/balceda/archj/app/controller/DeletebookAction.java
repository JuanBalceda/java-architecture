package com.balceda.archj.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.dao.implementation.jpa.BookDAOImpl;
import com.balceda.archj.app.model.Book;

public class DeletebookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDAOImpl bookDAO = new BookDAOImpl();

		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book.setIsbn(isbn);
		bookDAO.delete(book);

		return "Showbooks.do";
	}

}
