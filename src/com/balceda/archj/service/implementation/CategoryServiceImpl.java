package com.balceda.archj.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balceda.archj.dao.interfaces.CategoryDAO;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.exception.ExceptionService;
import com.balceda.archj.service.interfaces.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	public CategoryServiceImpl() {
	}

	@Override
	public void insert(Category t) throws ExceptionService {
		categoryDAO.insert(t);
	}

	@Override
	public List<Category> selectAll() throws ExceptionService {
		return categoryDAO.selectAll();
	}

	@Override
	public Category selectById(String id) throws ExceptionService {
		return categoryDAO.selectById(id);
	}

	@Override
	public void update(Category t) throws ExceptionService {
		categoryDAO.update(t);
	}

	@Override
	public void delete(Category t) throws ExceptionService {
		categoryDAO.delete(t);
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	@Override
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

}
