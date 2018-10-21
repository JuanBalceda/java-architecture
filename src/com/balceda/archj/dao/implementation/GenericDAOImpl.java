package com.balceda.archj.dao.implementation;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.dao.interfaces.GenericDAO;


@Transactional
public class GenericDAOImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> persistence;

	@PersistenceContext
	private EntityManager manager;

	public GenericDAOImpl() {
		this.persistence = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T t) throws ExceptionDAO {
		getManager().persist(t);
	}

	@Override
	public List<T> selectAll() throws ExceptionDAO {
		List<T> list;
		TypedQuery<T> query = getManager().createQuery("Select o from " + persistence.getSimpleName() + " o",
				persistence);
		list = query.getResultList();
		return list;
	}

	@Override
	public T selectById(Id id) throws ExceptionDAO {
		return getManager().find(persistence, id);
	}

	@Override
	public void update(T t) throws ExceptionDAO {
		getManager().merge(t);
	}

	@Override
	public void delete(T t) throws ExceptionDAO {
		getManager().remove(getManager().merge(t));
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
