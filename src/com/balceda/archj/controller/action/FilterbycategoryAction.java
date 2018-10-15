package com.balceda.archj.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.interfaces.BookService;
import com.balceda.archj.service.interfaces.CategoryService;

public class FilterbycategoryAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookService bookService = (BookService) getBean("bookService", request);
		CategoryService categoryService = (CategoryService) getBean("categoryService", request);

		List<Book> books = null;
		List<Category> categories = categoryService.selectAll();

		if (request.getParameter("category") == null || request.getParameter("category").equals("0")) {
			books = bookService.selectAll();
		} else {
			Category c = categoryService.selectById(request.getParameter("category"));
			books = bookService.selectByCategory(c);
		}
		request.setAttribute("categories", categories);
		request.setAttribute("books", books);
		return "showbooks.jsp";
	}

}
