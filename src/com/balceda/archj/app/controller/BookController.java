package com.balceda.archj.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balceda.archj.app.model.Book;

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
				
		if (request.getServletPath().equals("/showbooks.do")) {

			List<Book> books = Book.selectAll();
			List<String> categories = Book.selectAllCategories();

			request.setAttribute("books", books);
			request.setAttribute("categories", categories);
			dispatcher = request.getRequestDispatcher("showbooks.jsp");

		} else if (request.getServletPath().equals("/newbook.do")) {

			List<String> categories = Book.selectAllCategories();

			request.setAttribute("categories", categories);
			dispatcher = request.getRequestDispatcher("newbook.jsp");

		} else if (request.getServletPath().equals("/insertbook.do")) {

			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String category = request.getParameter("category");
			Book book = new Book(isbn, title, category);
			book.insert();

			dispatcher = request.getRequestDispatcher("showbooks.do");

		} else if (request.getServletPath().equals("/deletebook.do")) {

			String isbn = request.getParameter("isbn");
			Book book = new Book();
			book.setIsbn(isbn);
			book.delete();

			dispatcher = request.getRequestDispatcher("showbooks.do");
			
		} else if (request.getServletPath().equals("/editbook.do")) {

			String isbn = request.getParameter("isbn");
			List<String> categories = Book.selectAllCategories();
			Book book = Book.selectById(isbn);

			request.setAttribute("categories", categories);
			request.setAttribute("book", book);
			dispatcher = request.getRequestDispatcher("editbook.jsp");

		} else if (request.getServletPath().equals("/updatebook.do")) {
			
			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String category = request.getParameter("category");
			Book libro = new Book(isbn, title, category);
			libro.update();
			dispatcher = request.getRequestDispatcher("showbooks.do");
			
		} else {
			
			List<Book> books = null;
			List<String> categories = Book.selectAllCategories();

			if (request.getParameter("category") == null || request.getParameter("category").equals("0")) {
				books = Book.selectAll();
			} else {
				books = Book.selectByCategory(request.getParameter("category"));
			}
			request.setAttribute("categories", categories);
			request.setAttribute("books", books);
			dispatcher = request.getRequestDispatcher("showbooks.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
