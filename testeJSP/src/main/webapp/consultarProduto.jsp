<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeiro Projeto</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
		<nav class="navBar">
		<ul>
			<li><span style="color:yellow">Primeiro</span></li>
			<li><img alt="" src=""></li>
			<li><a href="cadastrarProduto.jsp">Cadastrar Produto</a></li>
			<li><a href="./consultarProduto.jsp">Consultar Produto</a></li>
		</ul>
	</nav>
	
	<main class="main">
		<form action="" method="get" class="formulario">
			<div>
				<label><strong>Busca pela Descrição:</strong></label>
				<input type="text" name="descricao">
			</div>
			<br>
			<div>
				<input id="btnEnviar" type="submit" name="salvar" value="Consultar Produto">
			</div>
			
		</form>
	</main>
</body>
</html>