<%@page import="com.balceda.archj.app.dao.exceptions.DAOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.balceda.archj.app.model.Book"%>

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
		Book book = (Book) request.getAttribute("book");
		List<String> list = (List<String>) request.getAttribute("categories");
	%>
	<form id="form" action="updatebook.do">
		<fieldset>
			<legend>Edit book:</legend>
			<p>
				<label for="isbn">ISBN:</label><input id="isbn" type="text"
					name="isbn" value="<%=book.getIsbn()%>" />
			</p>
			<p>
				<label for="title">Title:</label><input id="title" type="text"
					name="title" value="<%=book.getTitle()%>" />
			</p>
			<p>
				<label for="category">Category:</label> <select name="category">
					<option value="0">Select a category</option>
					<%
						for (String c : list) {
							if (book.getCategory().equals(c)) {
					%>
					<option value="<%=c.toString()%>" selected="selected"><%=c.toString()%></option>
					<%
							} else {
					%>
					<option value="<%=c.toString()%>"><%=c.toString()%></option>
					<%
							}
						};
					%>
				</select>
			</p>
			<p>
				<input type="button" value="Update" onclick="validation()" />
			</p>
		</fieldset>
	</form>
	<p>
		<a href="showbooks.do">Show Books</a>
	</p>
	<script src="assets/js/validation.js"></script>
</body>
</html>