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

public class EditbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factory = DAOAbstractFactory.getInstance();
		
		BookDAO bookDAO = factory.getBookDAO();
		CategoryDAO categoryDAO = factory.getCategoryDAO();

		String isbn = request.getParameter("isbn");
		List<Category> categories = categoryDAO.selectAll();
		Book book = bookDAO.selectById(isbn);

		request.setAttribute("categories", categories);
		request.setAttribute("book", book);
		return "editbook.jsp";
	}

}
