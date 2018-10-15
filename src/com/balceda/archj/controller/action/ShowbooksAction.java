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

public class ShowbooksAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = new BookServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();

		List<Book> books = bookService.selectAll();
		List<Category> categories = categoryService.selectAll();

		request.setAttribute("books", books);
		request.setAttribute("categories", categories);
		return "showbooks.jsp";
	}

}
