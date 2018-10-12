package com.balceda.archj.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.balceda.archj.app.util.HibernateHelper;

@Entity
@Table(name="categories")
public class Category {

	@Id
	private String id;
	private String description;
	
	@OneToMany
	@JoinColumn(name="id")
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
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		List<Category> list = session.createQuery("from Category category").list();
		session.close();
		return list;
	}
}

