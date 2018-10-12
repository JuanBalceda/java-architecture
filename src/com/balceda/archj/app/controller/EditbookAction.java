package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.dao.implementation.jpa.BookDAOImpl;
import com.balceda.archj.app.dao.implementation.jpa.CategoryDAOImpl;
import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public class EditbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDAOImpl bookDAO = new BookDAOImpl();
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

		String isbn = request.getParameter("isbn");
		List<Category> categories = categoryDAO.selectAll();
		Book book = bookDAO.selectById(isbn);

		request.setAttribute("categories", categories);
		request.setAttribute("book", book);
		return "editbook.jsp";
	}

}
