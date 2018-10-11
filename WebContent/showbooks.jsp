<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="Filterbycategory.do">
		<select name="category">
			<option value="0">Select a category</option>
			<c:forEach var="category" items="${categories}">
				<option value="${category}">${category}</option>
			</c:forEach>
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
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.isbn}</td>
					<td>${book.title}</td>
					<td>${book.category}</td>
					<td><a href="Editbook.do?isbn=${book.isbn}">Edit</a> <a
						href="Deletebook.do?isbn=${book.isbn}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="Newbook.do">Create new book</a>
</body>
</html>