package com.balceda.archj.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Category;
import com.balceda.archj.service.interfaces.CategoryService;

public class NewbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryService categoryService = (CategoryService) getBean("categoryService", request);
		
		List<Category> categories = categoryService.selectAll();

		request.setAttribute("categories", categories);
		return "newbook.jsp";
	}

}
