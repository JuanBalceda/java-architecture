package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public class ShowbooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Book> books = Book.selectAll();
		List<Category> categories = Category.selectAll();

		request.setAttribute("books", books);
		request.setAttribute("categories", categories);
		return "showbooks.jsp";
	}

}
