<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Architecture Book</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" />
<link rel="stylesheet" href="assets/css/style.css" type="text/css"
	media="screen" charset="utf-8" />
</head>
<body>

	<%
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String category = request.getParameter("category");

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_architecture", "root", "");
			statement = connection.createStatement();
			String query = "select * from books";
			resultSet = statement.executeQuery(query);
	%>
	<table>
		<thead>
			<tr>
				<td>ISBN</td>
				<td>Title</td>
				<td>Category</td>
			</tr>
		</thead>
		<tbody>
			<%
				while (resultSet.next()) {
			%>
			<tr>
				<td><%=resultSet.getString("isbn")%></td>
				<td><%=resultSet.getString("title")%></td>
				<td><%=resultSet.getString("category")%></td>
			</tr>
			<%
				}
					;
			%>
		</tbody>
	</table>
	<a href="newbook.xhtml">Create new book</a>
	<%
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


</body>
</html>