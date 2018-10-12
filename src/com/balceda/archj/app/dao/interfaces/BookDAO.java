package com.balceda.archj.app.dao.interfaces;

import java.util.List;

import com.balceda.archj.app.dao.exception.ExceptionDAO;
import com.balceda.archj.app.model.Book;
import com.balceda.archj.app.model.Category;

public interface BookDAO extends GenericDAO<Book, String> {
	public List<Book> selectByCategory(Category category) throws ExceptionDAO;
}
