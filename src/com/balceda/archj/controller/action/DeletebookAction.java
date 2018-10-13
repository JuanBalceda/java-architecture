package com.balceda.archj.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.dao.factory.DAOAbstractFactory;
import com.balceda.archj.dao.factory.DAOFactory;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.model.Book;

public class DeletebookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DAOFactory factory = DAOAbstractFactory.getInstance();
		
		BookDAO bookDAO = factory.getBookDAO();

		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book.setIsbn(isbn);
		bookDAO.delete(book);

		return "Showbooks.do";
	}

}
