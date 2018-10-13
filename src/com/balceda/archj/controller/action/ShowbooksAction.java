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

public class ShowbooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factory = DAOAbstractFactory.getInstance();
		
		BookDAO bookDAO = factory.getBookDAO();
		CategoryDAO categoryDAO = factory.getCategoryDAO();
		
		List<Book> books = bookDAO.selectAll();
		List<Category> categories = categoryDAO.selectAll();

		request.setAttribute("books", books);
		request.setAttribute("categories", categories);
		return "showbooks.jsp";
	}

}
