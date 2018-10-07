<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
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
Ha ocurrido un error en la aplicación: <%=exception.getMessage() %><br>
Error interno: <br>
<%=exception.getCause().getMessage() %>
</body>
</html>