<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>

<%
	String isbn = request.getParameter("isbn");
	String title = request.getParameter("title");
	String category = request.getParameter("category");

	Connection connection = null;
	Statement statement = null;
	int filas = 0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_architecture", "root", "");
		statement = connection.createStatement();
		String query = "insert into books(isbn, title,category)" + "values('" + isbn + "', '" + title + "', '"
				+ category + "')";
		filas = statement.executeUpdate(query);
		response.sendRedirect("showbooks.jsp");
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Architecture Book</title>
</head>
<body>

</body>
</html>