package com.balceda.archj.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.implementation.jpa.BookServiceImpl;
import com.balceda.archj.service.interfaces.BookService;

public class InsertbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = new BookServiceImpl();

		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Category c = new Category();
		c.setId(category);
		Book book = new Book(isbn, title, c);
		bookService.insert(book);

		return "Showbooks.do";
	}

}
