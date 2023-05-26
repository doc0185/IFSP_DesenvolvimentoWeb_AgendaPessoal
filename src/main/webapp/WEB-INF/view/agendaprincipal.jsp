<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Principal</title>
</head>
<body>
<h1>Usuário Logado!</h1>


<table border="1">
<tr><th>Titulo</th><th>Descricao</th><th>Data_inicio</th><th>Data_fim</th><th>Status</th></tr>

<c:forEach items="${requestScope.lista}" var="c">
	<tr>
	<td>${c.titulo}</td>
	<td>${c.descricao}</td>
	<td>${c.data_inicio}</td>
	<td>${c.data_conclusao}</td>
	<td>${c.status}</td>
	<td><a href="/agendaPessoal/deleteTarefa?id_tarefa=${c.id}">Deletar Tarefa!</a></td>
	<td><a href="/agendaPessoal/edicaoTarefa?id_tarefa=${c.id}">Editar Tarefa!</a></td>
	</tr>
</c:forEach>

</table>

	
<a href="/agendaPessoal/cadastroTarefa">Cadastrar nova Tarefa!</a>
</body>
</html>