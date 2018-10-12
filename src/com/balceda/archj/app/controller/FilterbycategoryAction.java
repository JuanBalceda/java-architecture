package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.dao.implementation.jpa.BookDAOImpl;
import com.balceda.archj.app.dao.implementation.jpa.CategoryDAOImpl;
import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public class FilterbycategoryAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDAOImpl bookDAO = new BookDAOImpl();
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

		List<Book> books = null;
		List<Category> categories = categoryDAO.selectAll();

		if (request.getParameter("category") == null || request.getParameter("category").equals("0")) {
			books = bookDAO.selectAll();
		} else {
			Category c = categoryDAO.selectById(request.getParameter("category"));
			books = bookDAO.selectByCategory(c);
		}
		request.setAttribute("categories", categories);
		request.setAttribute("books", books);
		return "showbooks.jsp";
	}

}
