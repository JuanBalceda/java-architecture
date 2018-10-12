package com.balceda.archj.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.balceda.archj.app.util.HibernateHelper;

@Entity
@Table(name = "books")
public class Book {

	@Id
	private String isbn;
	private String title;
	
	@ManyToOne
	@JoinColumn(name="category")
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
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
	}

	public static List<Book> selectAll() {
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		List<Book> list = session.createQuery("from Book book right join fetch book.category").list();
		session.close();
		return list;
	}

	public static Book selectById(String isbn) {
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		Book book = (Book) session.get(Book.class, isbn);
		session.close();
		return book;
	}

	public static List<Book> selectByCategory(String category) {
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Book book where book.category=:category");
		query.setString("category", category);
		List<Book> list = query.list();
		session.close();
		return list;
	}

	public void update() {
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}

	public void delete() {
		SessionFactory sessionFactory = HibernateHelper.getSession();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
	}

}
