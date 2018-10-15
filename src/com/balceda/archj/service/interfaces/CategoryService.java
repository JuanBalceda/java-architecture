package com.balceda.archj.service.interfaces;

import com.balceda.archj.dao.interfaces.CategoryDAO;
import com.balceda.archj.model.Category;

public interface CategoryService extends GenericService<Category, String> {
	public void setCategoryDAO(CategoryDAO categoryDAO);

	public CategoryDAO getCategoryDAO();
}
