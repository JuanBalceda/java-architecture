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
	<form id="form" action="updatebook.do">
		<fieldset>
			<legend>Edit book:</legend>
			<p>
				<label for="isbn">ISBN:</label><input id="isbn" type="text"
					name="isbn" value="${book.isbn}" />
			</p>
			<p>
				<label for="title">Title:</label><input id="title" type="text"
					name="title" value="${book.title}" />
			</p>
			<p>
				<label for="category">Category:</label>
				<select name="category">
					<option value="0">Select a category</option>
					<c:forEach var="category" items="${categories}">
						<option value="${category}">${category}</option>
					</c:forEach>
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