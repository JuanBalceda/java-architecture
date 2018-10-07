package com.balceda.archj.app.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper<T> {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/java_architecture";
	private static final String USER = "root";
	private static final String PASS = "";

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
			System.out.println("Error loading driver: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error connecting database: " + e.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Error closing statement: " + e.getMessage());
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Error closing connection: " + e.getMessage());
				}
			}
		}

		return rows;
	}

	public List<T> select(String query, Class c) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<T> list = new ArrayList<>();

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				T object = (T) Class.forName(c.getName()).newInstance();
				Method[] methods = object.getClass().getDeclaredMethods();
				for (Method m : methods) {
					System.out.println(m.getName());
				}
				for (int i = 0; i < methods.length; i++) {
					if (methods[i].getName().startsWith("set")) {
						System.out.println(methods[i].getName());
						methods[i].invoke(object, resultSet.getString(methods[i].getName().substring(3)));
						System.out.println(methods[i].getName().substring(3));
					}
					if (object.getClass().getName().equals("java.lang.String")) {
						object = (T) resultSet.getString(1);
					}
				}
				list.add(object);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error connecting database: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error casting class: " + e.getMessage());
		}
		return list;
	}
}
