package com.balceda.archj.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.interfaces.BookService;
import com.balceda.archj.service.interfaces.CategoryService;

public class EditbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = (BookService) getBean("bookService", request);
		CategoryService categoryService = (CategoryService) getBean("categoryService", request);

		String isbn = request.getParameter("isbn");
		List<Category> categories = categoryService.selectAll();
		Book book = bookService.selectById(isbn);

		request.setAttribute("categories", categories);
		request.setAttribute("book", book);
		return "editbook.jsp";
	}

}
