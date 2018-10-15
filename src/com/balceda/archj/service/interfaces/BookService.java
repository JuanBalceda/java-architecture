package com.balceda.archj.service.interfaces;

import java.util.List;

import com.balceda.archj.model.Book;
import com.balceda.archj.model.Category;
import com.balceda.archj.service.exception.ExceptionService;

public interface BookService extends GenericService<Book, String> {
	public List<Book> selectByCategory(Category category) throws ExceptionService;
}
