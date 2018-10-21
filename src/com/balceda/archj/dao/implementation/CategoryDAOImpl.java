package com.balceda.archj.dao.implementation;

import org.springframework.stereotype.Repository;

import com.balceda.archj.dao.interfaces.CategoryDAO;
import com.balceda.archj.model.Category;

@Repository
public class CategoryDAOImpl extends GenericDAOImpl<Category, String> implements CategoryDAO {

	public CategoryDAOImpl() {
	}

}
