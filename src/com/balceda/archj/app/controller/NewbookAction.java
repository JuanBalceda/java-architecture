package com.balceda.archj.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.dao.implementation.jpa.CategoryDAOImpl;
import com.balceda.archj.app.model.Category;

public class NewbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

		List<Category> categories = categoryDAO.selectAll();

		request.setAttribute("categories", categories);
		return "newbook.jsp";
	}

}
