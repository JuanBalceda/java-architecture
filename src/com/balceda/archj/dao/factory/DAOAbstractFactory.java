package com.balceda.archj.dao.factory;

public abstract class DAOAbstractFactory {

	public static DAOFactory getInstance() {
		String type = "JPA";
		if (type.equals("Hibernate")) {
			//return new DAOHibernateFactory();
			return null;
		} else {
			return new DAOJPAFactory();
		}
	}
}
