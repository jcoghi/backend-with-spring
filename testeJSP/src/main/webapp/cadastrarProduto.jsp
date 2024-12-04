<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Primeiro Projeto</title>
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
		<form action="cadastrarProduto" method="post" class="formulario">
			<div>
				<label for="descricao"><strong>Descrição:</strong></label>
				<input type="text" id="descricao" name="decricao">
			</div>
			
			<div>
				<label for="quantidade"><strong>Quantidade:</strong></label>
				<input type="number" id="quantidade" name="quantidade">
			</div>
			
			<div>
				<label for="preco"><strong>Preço:</strong></label>
				<input type="text" id="preco" name="preco">
			</div>
			
			<div>
				<label for="online"><strong>Disponível On-Line:</strong></label>
				<input type="checkbox" id="online" name="online">
			</div>
			<br>
			<div>
				<input type="submit" id="btnSalvar" name="salvar" value="Cadastrar Produto">
			</div>
			
			
		</form>
	</main>

</body>
</html>