package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;

public class EditbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		List<String> categories = Book.selectAllCategories();
		Book book = Book.selectById(isbn);

		request.setAttribute("categories", categories);
		request.setAttribute("book", book);
		return "editbook.jsp";
	}

}
