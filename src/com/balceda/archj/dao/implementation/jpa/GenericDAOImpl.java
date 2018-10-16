package com.balceda.archj.dao.implementation.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.dao.interfaces.GenericDAO;

public class GenericDAOImpl<T, Id extends Serializable> extends JpaDaoSupport implements GenericDAO<T, Id> {

	private Class<T> persistence;
	
	public GenericDAOImpl() {
		this.persistence = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T t) throws ExceptionDAO {
		getJpaTemplate().persist(t);
	}

	@Override
	public List<T> selectAll() throws ExceptionDAO {
		return getJpaTemplate().find("Select o from " + persistence.getSimpleName() + " o");
	}

	@Override
	public T selectById(Id id) throws ExceptionDAO {
		return getJpaTemplate().find(persistence, id);
	}

	@Override
	public void update(T t) throws ExceptionDAO {
		getJpaTemplate().merge(t);
	}

	@Override
	public void delete(T t) throws ExceptionDAO {
		getJpaTemplate().remove(getJpaTemplate().merge(t));
	}
}
