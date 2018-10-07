<%@page import="com.balceda.archj.app.dao.exceptions.DAOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.balceda.archj.app.model.Book"%>
<%
	String isbn = request.getParameter("isbn");

	Book book = new Book();
	book.setIsbn(isbn);
	book.delete();
	response.sendRedirect("showbooks.jsp");
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