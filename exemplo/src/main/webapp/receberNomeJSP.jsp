<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% out.println(request.getParameter("nome")); %>
	
	<%
		String nome = "<br>nome recebido " + request.getParameter("nome");
		out.print(nome);
	%>
	
	<%=  "<br>Nome recebido = " + request.getParameter("nome")%>
</body>
</html>