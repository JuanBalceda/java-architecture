package com.balceda.archj.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Book;
import com.balceda.archj.service.implementation.jpa.BookServiceImpl;
import com.balceda.archj.service.interfaces.BookService;

public class DeletebookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = new BookServiceImpl();

		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book.setIsbn(isbn);
		bookService.delete(book);

		return "Showbooks.do";
	}

}
