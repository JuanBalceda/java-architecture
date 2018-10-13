package com.balceda.archj.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.dao.factory.DAOAbstractFactory;
import com.balceda.archj.dao.factory.DAOFactory;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.dao.interfaces.CategoryDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;

public class FilterbycategoryAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factory = DAOAbstractFactory.getInstance();
		
		BookDAO bookDAO = factory.getBookDAO();
		CategoryDAO categoryDAO = factory.getCategoryDAO();

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
