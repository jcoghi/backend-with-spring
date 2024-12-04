<%@page import="model.CrudDAO"%>
<%@page import="controller.Livro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		Livro livro = new Livro();
		livro.setId_livro(Integer.parseInt(request.getParameter("id")));
		
		CrudDAO apagar = new CrudDAO();
		apagar.ExcluirLivro(livro);
		out.println("Livro exluído com sucesso!");
	} catch(Exception e) {
		e.printStackTrace();
	}
	%>
	<a href="index.html">Voltar</a>

</body>
</html>