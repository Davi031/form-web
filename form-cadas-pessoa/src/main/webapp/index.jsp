<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilo.css">
<title>Primeira Página JSP</title>
</head>
<body>
	<%
	String app = request.getParameter("app");
	if (app == null)
		app = "JSP";
	out.print("Aqui é um conteudo " + app);
	%>
	<br>
	<div class="bt3">
		<a href="form-cadastro.jsp">Novo Cadastro</a>
	</div>
	<br>
	<div class="bt3">
		<a href="listaPessoas.jsp">Lista de Pessoas</a>
	</div>
</body>
</html>