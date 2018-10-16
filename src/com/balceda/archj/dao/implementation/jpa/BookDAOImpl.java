package com.balceda.archj.dao.implementation.jpa;

import java.util.List;

import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;

public class BookDAOImpl extends GenericDAOImpl<Book, String> implements BookDAO {

	public BookDAOImpl() {
	}

	@Override
	public List<Book> selectByCategory(Category category) throws ExceptionDAO {
		return getJpaTemplate().find("Select b from Book b where b.category=?1", category);
	}


	@Override
	public List<Book> selectAll() throws ExceptionDAO {
		return getJpaTemplate().find("Select b from Book b JOIN FETCH b.category");
	}


}
