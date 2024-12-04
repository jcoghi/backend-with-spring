<jsp:useBean id="calcula" class="beans.BeanCurso" type="beans.BeanCurso"></jsp:useBean>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeiro Programa</title>
</head>
<body>
	<h1>Primeiro Programa</h1>
	<% out.println("Escrevendo com JSP");  %>
	<!-- Expressão de saída  -->
	<%= "<br>Lorem ipson" %>
	
	<form action="receberNomeJSP.jsp">
	<label for="nome">Nome:</label>
		<input type="text" id="nome" name="nome">
		<input type="submit" value="enviar">
	</form>
	
	<%= calcula.calcula(50) %>
	
	<jsp:setProperty property="" name="calcula"/>
	
	
</body>
</html>