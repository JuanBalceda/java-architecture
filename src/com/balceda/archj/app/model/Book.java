package com.balceda.archj.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import com.balceda.archj.app.util.JPAHelper;

@Entity
@Table(name = "books")
public class Book {

	@Id
	private String isbn;
	private String title;

	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;

	public Book() {
	}

	public Book(String isbn, String title, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void insert() {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(this);
			transaction.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	public static List<Book> selectAll() {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Book> query = manager.createQuery("Select b from Book b join fetch b.category", Book.class);
		List<Book> list = null;
		try {
			list = query.getResultList();
		} finally {
			manager.close();
		}
		return list;
	}

	public static Book selectById(String isbn) {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Book> query = manager.createQuery("Select b from Book b join fetch b.category where b.isbn=?1",
				Book.class);
		query.setParameter(1, isbn);
		Book book = null;
		try {
			book = query.getSingleResult();
		} finally {
			manager.close();
		}
		return book;
	}

	public static List<Book> selectByCategory(Category category) {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Book> query = manager.createQuery("Select b from Book b where b.category=?1", Book.class);
		query.setParameter(1, category);
		List<Book> list = null;
		try {
			list = query.getResultList();
		} finally {
			manager.close();
		}
		return list;
	}

	public void update() {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(this);
			transaction.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	public void delete() {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(manager.merge(this));
			transaction.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

}
