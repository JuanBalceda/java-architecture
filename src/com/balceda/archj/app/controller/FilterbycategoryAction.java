package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public class FilterbycategoryAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Book> books = null;
		List<Category> categories = Category.selectAll();

		if (request.getParameter("category") == null || request.getParameter("category").equals("0")) {
			books = Book.selectAll();
		} else {
			books = Book.selectByCategory(request.getParameter("category"));
		}
		request.setAttribute("categories", categories);
		request.setAttribute("books", books);
		return "showbooks.jsp";
	}

}
