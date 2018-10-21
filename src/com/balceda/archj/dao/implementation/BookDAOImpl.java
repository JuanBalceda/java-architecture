package com.balceda.archj.dao.implementation;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;

@Repository
public class BookDAOImpl extends GenericDAOImpl<Book, String> implements BookDAO {

	public BookDAOImpl() {
	}

	@Override
	public List<Book> selectByCategory(Category category) throws ExceptionDAO {
		List<Book> list;
		TypedQuery<Book> query = getManager().createQuery("Select b from Book b where b.category=?1", Book.class);
		query.setParameter(1, category);
		list = query.getResultList();
		return list;
	}

	@Override
	public List<Book> selectAll() throws ExceptionDAO {
		List<Book> list;
		TypedQuery<Book> query = getManager().createQuery("Select b from Book b JOIN FETCH b.category", Book.class);
		list = query.getResultList();
		return list;
	}

}
