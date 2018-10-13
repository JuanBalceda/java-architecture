package com.balceda.archj.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	private static final EntityManagerFactory EMF = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("ArchJ");
		} catch (Throwable e) {
			throw new RuntimeException("Error creating JPA Factory: "+e);
		}
	}

	public static EntityManagerFactory getJPAFactory() {
		return EMF;
	}
}
