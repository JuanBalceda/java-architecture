package com.balceda.archj.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import com.balceda.archj.app.util.JPAHelper;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	private String id;
	private String description;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Book> books;

	public Category() {
	}

	public Category(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public static List<Category> selectAll() {
		EntityManagerFactory emf = JPAHelper.getJPAFactory();
		EntityManager manager = emf.createEntityManager();
		TypedQuery<Category> query = manager.createQuery("Select c from Category c", Category.class);
		List<Category> list = null;
		try {
			list = query.getResultList();
		} finally {
			manager.close();
		}
		return list;
	}

	public static Category selectById(String id) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Category> consulta = manager.createQuery("Select c from Category c where c.id=?1", Category.class);
		consulta.setParameter(1, id);
		Category categoria = null;
		try {
			categoria = consulta.getSingleResult();
		} finally {
			manager.close();
		}
		return categoria;
	}
}
