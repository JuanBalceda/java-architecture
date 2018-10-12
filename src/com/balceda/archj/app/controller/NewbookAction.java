package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Category;

public class NewbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Category> categories = Category.selectAll();

		request.setAttribute("categories", categories);
		return "newbook.jsp";
	}

}
