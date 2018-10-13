package com.balceda.archj.dao.implementation.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.balceda.archj.dao.JPAHelper;
import com.balceda.archj.dao.exception.ExceptionDAO;
import com.balceda.archj.dao.interfaces.GenericDAO;

public class GenericDAOImpl<T,Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> persistence;
	
	public GenericDAOImpl() {
		this.persistence = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void insert(T t) throws ExceptionDAO {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(t);
			transaction.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}		
	}

	@Override
	public List<T> selectAll() throws ExceptionDAO {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<T> query = 
				manager.createQuery("Select o from "+persistence.getSimpleName()+" o", persistence);
		List<T> list = null;
		try {
			list = query.getResultList();
		} finally {
			manager.close();
		}
		return list;
	}

	@Override
	public T selectById(Id id) throws ExceptionDAO {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		T object = null;
		try {
			object = (T) manager.find(persistence, id);
		} finally {
			manager.close();
		}
		return object;
	}

	@Override
	public void update(T t) throws ExceptionDAO {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(t);
			transaction.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}		
	}

	@Override
	public void delete(T t) throws ExceptionDAO {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(t));
			transaction.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}		
	}

}
