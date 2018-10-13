package com.balceda.archj.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.dao.factory.DAOAbstractFactory;
import com.balceda.archj.dao.factory.DAOFactory;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;

public class UpdatebookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factory = DAOAbstractFactory.getInstance();

		BookDAO bookDAO = factory.getBookDAO();

		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Category c = new Category();
		c.setId(category);
		Book book = new Book(isbn, title, c);
		bookDAO.update(book);
		return "Showbooks.do";
	}

}
