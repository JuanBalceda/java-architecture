package com.balceda.archj.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Book;
import com.balceda.archj.service.interfaces.BookService;

public class DeletebookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = (BookService) getBean("bookService", request);

		String isbn = request.getParameter("isbn");
		Book book = new Book();
		book.setIsbn(isbn);
		bookService.delete(book);

		return "Showbooks.do";
	}

}
