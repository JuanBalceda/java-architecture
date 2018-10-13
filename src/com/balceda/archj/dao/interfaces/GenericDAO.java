package com.balceda.archj.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.balceda.archj.dao.exception.ExceptionDAO;

public interface GenericDAO<T, Id extends Serializable> {
	public abstract void insert(T t) throws ExceptionDAO;

	public abstract List<T> selectAll() throws ExceptionDAO;

	public abstract T selectById(Id id) throws ExceptionDAO;

	public abstract void update(T t) throws ExceptionDAO;

	public abstract void delete(T t) throws ExceptionDAO;
}
