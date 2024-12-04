<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Livro</title>
</head>
<body>
	<h1>Excluir Livro</h1>
	<form action="excluirLivro.jsp" method="post">		
		
		<label for="codigo">Código do livro:</label>
		<input type="text" id="codigo" name="codigo"
		 value="<%= request.getParameter("id")%>">
		
		<label for="nome">Nome do livro:</label>
		<input type="text" id="nome" name="nome"
		value="<%= request.getParameter("nome")%>">
		<br>
		<button type="submit">Excluir</button>
	</form>
	<a href="index.html">Cadastrar </a>
	<a href="listarLivros.jsp">Buscar </a>
</body>
</html>