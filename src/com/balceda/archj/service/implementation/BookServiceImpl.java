package com.balceda.archj.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.exception.ExceptionService;
import com.balceda.archj.service.interfaces.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	public BookServiceImpl() {
	}

	@Override
	public void insert(Book t) throws ExceptionService {
		bookDAO.insert(t);
	}

	@Override
	public List<Book> selectAll() throws ExceptionService {
		return bookDAO.selectAll();
	}

	@Override
	public Book selectById(String id) throws ExceptionService {
		return bookDAO.selectById(id);
	}

	@Override
	public void update(Book t) throws ExceptionService {
		bookDAO.update(t);
	}

	@Override
	public void delete(Book t) throws ExceptionService {
		bookDAO.delete(t);
	}

	@Override
	public List<Book> selectByCategory(Category category) throws ExceptionService {
		return bookDAO.selectByCategory(category);
	}

	@Override
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	@Override
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

}
