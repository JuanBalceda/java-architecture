package com.balceda.archj.dao.implementation.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.balceda.archj.dao.JPAHelper;
import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;

public class BookDAOImpl extends GenericDAOImpl<Book, String> implements BookDAO{

	public BookDAOImpl() {
	}

	@Override
	public List<Book> selectByCategory(Category category) {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Book> query = manager.createQuery("Select b from Book b where b.category=?1", Book.class);
		query.setParameter(1, category);
		List<Book> list = null;
		try {
			list = query.getResultList();
		} finally {
			manager.close();
		}
		return list;
	}

	@Override
	public List<Book> selectAll() throws ExceptionDAO {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Book> query = 
				manager.createQuery("Select b from Book b JOIN FETCH b.category", Book.class);
		List<Book> list = null;
		try {
			list = query.getResultList();
		} finally {
			manager.close();
		}
		return list;
	}
}
	