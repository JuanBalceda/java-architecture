package com.balceda.archj.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.implementation.jpa.BookServiceImpl;
import com.balceda.archj.service.implementation.jpa.CategoryServiceImpl;
import com.balceda.archj.service.interfaces.BookService;
import com.balceda.archj.service.interfaces.CategoryService;

public class EditbookAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = new BookServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();

		String isbn = request.getParameter("isbn");
		List<Category> categories = categoryService.selectAll();
		Book book = bookService.selectById(isbn);

		request.setAttribute("categories", categories);
		request.setAttribute("book", book);
		return "editbook.jsp";
	}

}
