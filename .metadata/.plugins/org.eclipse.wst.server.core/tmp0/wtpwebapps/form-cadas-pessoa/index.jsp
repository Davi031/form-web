<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira P�gina JSP</title>
</head>
<body>
Primeira p�gina JSP<br>
<%
	String app = request.getParameter("app");
	out.print("Aqui � um conte�do "+app);
%>
</body>
</html>