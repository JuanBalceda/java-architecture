package com.balceda.archj.dao.interfaces;

import java.util.List;

import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;

public interface BookDAO extends GenericDAO<Book, String> {
	public List<Book> selectByCategory(Category category) throws ExceptionDAO;
}
