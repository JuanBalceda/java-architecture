package com.balceda.archj.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Error occured creating session factory: " + e);
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSession() {
		return SESSION_FACTORY;
	}
}
