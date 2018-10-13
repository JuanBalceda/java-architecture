package com.balceda.archj.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.dao.factory.DAOAbstractFactory;
import com.balceda.archj.dao.factory.DAOFactory;
import com.balceda.archj.dao.interfaces.CategoryDAO;
import com.balceda.archj.model.Category;

public class NewbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factory = DAOAbstractFactory.getInstance();
		
		CategoryDAO categoryDAO = factory.getCategoryDAO();

		List<Category> categories = categoryDAO.selectAll();

		request.setAttribute("categories", categories);
		return "newbook.jsp";
	}

}
