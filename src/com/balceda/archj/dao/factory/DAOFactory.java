package com.balceda.archj.dao.factory;

import com.balceda.archj.dao.interfaces.BookDAO;
import com.balceda.archj.dao.interfaces.CategoryDAO;

public interface DAOFactory {

	public BookDAO getBookDAO();

	public CategoryDAO getCategoryDAO();
}
