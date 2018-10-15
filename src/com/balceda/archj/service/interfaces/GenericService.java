package com.balceda.archj.service.interfaces;

import java.io.Serializable;
import java.util.List;

import com.balceda.archj.service.exception.ExceptionService;


public interface GenericService<T, Id extends Serializable> {
	public abstract void insert(T t) throws ExceptionService;

	public abstract List<T> selectAll() throws ExceptionService;

	public abstract T selectById(Id id) throws ExceptionService;

	public abstract void update(T t) throws ExceptionService;

	public abstract void delete(T t) throws ExceptionService;
}
