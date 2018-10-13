package com.balceda.archj.dao.factory;

import com.balceda.archj.dao.implementation.jpa.BookDAOImpl;
import com.balceda.archj.dao.implementation.jpa.CategoryDAOImpl;
import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.dao.interfaces.CategoryDAO;

public class DAOJPAFactory implements DAOFactory {

	@Override
	public BookDAO getBookDAO() {
		return new BookDAOImpl();
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return new CategoryDAOImpl();
	}
}
