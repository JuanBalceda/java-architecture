<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.balceda.archj.app.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Architecture Book</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet" />
<link rel="stylesheet" href="assets/css/style.css" type="text/css" />
</head>
<body>

	<%
		List<String> list = new ArrayList<>();
		list = Book.selectAllCategories();
	%>
	<select name="category">
		<option value="0">Select a category</option>
		<%
			for (String c : list) {
		%>
		<option value="<%=c.toString()%>"><%=c.toString()%></option>
		<%
			};
		%>
	</select>
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
				List<Book> books = new ArrayList<>();
				books = Book.selectAll();
				for (Book b : books) {
			%>
			<tr>
				<td><%=b.getIsbn()%></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getCategory()%></td>
			</tr>
			<%
				};
			%>
		</tbody>
	</table>
	<a href="newbook.jsp">Create new book</a>
</body>
</html>