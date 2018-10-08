<%@page import="com.balceda.archj.app.dao.exceptions.DAOException"%>
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

		list = (List<String>) request.getAttribute("categories");
	%>
	<form action="filter.do">
		<select name="category">
			<option value="0">Select a category</option>
			<%
				for (String c : list) {
					if (c.equals(request.getParameter("category"))) {
			%>
			<option value="<%=c.toString()%>" selected><%=c.toString()%></option>
			<%
					} else {
			%>
			<option value="<%=c.toString()%>"><%=c.toString()%></option>
			<%
					}
				};
			%>
		</select> <input type="submit" value="Filter">
	</form>
	<table>
		<thead>
			<tr>
				<td>ISBN</td>
				<td>Title</td>
				<td>Category</td>
				<td>Options</td>
			</tr>
		</thead>
		<tbody>
			<%
				List<Book> books = new ArrayList<>();
				books = (List<Book>) request.getAttribute("books");
				for (Book b : books) {
			%>
			<tr>
				<td><%=b.getIsbn()%></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getCategory()%></td>
				<td>
				<a href="editbook.do?isbn=<%=b.getIsbn()%>">Edit</a>
				<a href="deletebook.do?isbn=<%=b.getIsbn()%>">Delete</a></td>
			</tr>
			<%
				};
			%>
		</tbody>
	</table>
	<a href="newbook.do">Create new book</a>
</body>
</html>