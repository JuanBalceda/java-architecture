package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;

public class NewbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<String> categories = Book.selectAllCategories();

		request.setAttribute("categories", categories);
		return "newbook.jsp";
	}

}
