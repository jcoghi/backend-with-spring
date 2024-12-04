<%@page import="controller.Livro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CrudDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busca</title>
</head>
<body>
	<%
		try {
			CrudDAO busca = new CrudDAO();
			ArrayList<Livro> lista = busca.BuscarLivro();
			
			for(int i = 0; i < lista.size(); i++) {
				out.println("Código: " + lista.get(i).getId_livro() + "<br>");
				out.println("Nome: " + lista.get(i).getNome_livro() + "<br>");
				
				out.print("<a href='formExcluir.jsp?id= " 
				+ lista.get(i).getId_livro() + "&nome=" +
				lista.get(i).getNome_livro() + "'> Excluir</a>");
				out.print("<br><br>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>