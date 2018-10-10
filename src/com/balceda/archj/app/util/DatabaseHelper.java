package com.balceda.archj.app.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.balceda.archj.app.dao.exceptions.DAOException;

public class DatabaseHelper<T> {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/java_architecture";
	private static final String USER = "root";
	private static final String PASS = "";

	private static final Logger LOG = Logger.getLogger(DatabaseHelper.class.getPackage().getName());

	public int update(String query) {
		Connection connection = null;
		Statement statement = null;
		int rows = 0;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
			statement = connection.createStatement();
			rows = statement.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			// System.out.println("Error loading driver: " + e.getMessage());
			LOG.error("JDBC Driver not found: " + e.getMessage());
			throw new DAOException("JDBC Driver not found", e);
		} catch (SQLException e) {
			// System.out.println("Error connecting database: " + e.getMessage());
			LOG.error("SQL Sintax error: " + e.getMessage());
			throw new DAOException("SQL Sintax error", e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Error closing statement: " + e.getMessage());
					throw new DAOException("Error closing database statement", e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Error closing connection: " + e.getMessage());
					throw new DAOException("Error closing database connection", e);
				}
			}
		}

		return rows;
	}

	@SuppressWarnings("rawtypes")
	public List<T> select(String query, Class c) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<T> list = new ArrayList<T>();

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				T object = (T) Class.forName(c.getName()).newInstance();
				Method[] methods = object.getClass().getDeclaredMethods();

				for (int i = 0; i < methods.length; i++) {
					if (methods[i].getName().startsWith("set")) {
						methods[i].invoke(object, resultSet.getString(methods[i].getName().substring(3)));
					}
					if (object.getClass().getName().equals("java.lang.String")) {
						object = (T) resultSet.getString(1);
					}
				}
				list.add(object);
			}
		} catch (ClassNotFoundException e) {
			// System.out.println("Error loading driver: " + e.getMessage());
			LOG.error("JDBC Driver not found: " + e.getMessage());
			throw new DAOException("JDBC Driver not found", e);
		} catch (SQLException e) {
			// System.out.println("Error connecting database: " + e.getMessage());
			LOG.error("SQL Sintax error: " + e.getMessage());
			throw new DAOException("SQL Sintax error", e);
		} catch (Exception e) {
			System.out.println("Error casting class: " + e.getMessage());
			throw new DAOException("Casting error", e);
		}
		return list;
	}
}
