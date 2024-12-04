<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeiro Exemplo do Livro</title>
</head>
<body>
	<%! int intContaAcesso = 0; %>
	<%
	java.util.Date dataAtual = new java.util.Date();
	String strData = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
	%>
	<h2>Data atual: <%= strData %></h2>
	<%
		out.println("<h2>Contagem de atualizações </h2>")
	%>
</body>
</html>