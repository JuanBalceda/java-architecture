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
<form action="showbooks.jsp">
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
	<input type="submit" value="Filter">
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
				if(request.getParameter("category")==null || request.getParameter("category").equals("0")){
					books = Book.selectAll();
				}else{
					books = Book.selectByCategory(request.getParameter("category"));
				}
				for (Book b : books) {
			%>
			<tr>
				<td><%=b.getIsbn()%></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getCategory()%></td>
				<td><a href="editbook.jsp?isbn=<%=b.getIsbn()%>">Edit</a> <a href="deletebook.jsp?isbn=<%=b.getIsbn()%>">Delete</a></td>
			</tr>
			<%
				};
			%>
		</tbody>
	</table>
	<a href="newbook.jsp">Create new book</a>
</body>
</html>