<%@page import="model.CrudDAO"%>
<%@page import="controller.Livro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<%
	try {
		Livro livro = new Livro();
		livro.setNome_livro(request.getParameter("nome"));
		
		CrudDAO inserir = new CrudDAO();
		inserir.CadastrarLivro(livro);
		out.println("Cadastrado com sucesso!");
	} catch(Exception e) {
		e.printStackTrace();
	}
	%>
	<br>
	<a href="index.html">Voltar</a>
</body>
</html>