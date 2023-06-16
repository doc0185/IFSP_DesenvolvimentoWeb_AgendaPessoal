<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Principal</title>
<style><%@include file="/WEB-INF/view/style2.css"%></style>
</head>
<body>

<div class="box">
<h1>Tarefas do Usuário</h1>

<form action="<%=request.getContextPath() %>/listagemTarefa" method=post>
		<label>
 			<span>Filtrar por Título da Tarefa</span>
			<input type="text" class="input_text" name="tarefa_filtro" id="tarefa_filtro"/>
		</label>
		
		<label>
			<input type="submit" class="button" value="Enviar" />
		</label>
		
	</form>
<br>
<br>


<table border="1" class = "table">
<tr><th>Titulo</th><th>Descricao</th><th>Data_inicio</th><th>Data_fim</th><th>Status</th><th>Deletar</th><th>Editar</th></tr>

<c:forEach items="${requestScope.lista}" var="c">
	<tr>
	<td>${c.titulo}</td>
	<td>${c.descricao}</td>
	<td>${c.data_inicio}</td>
	<td>${c.data_conclusao}</td>
	<td>${c.status}</td>
	<td><a href="/agendaPessoal/deleteTarefa?id_tarefa=${c.id}" style="color: #6A5ACD">Deletar Tarefa!</a></td>
	<td><a href="/agendaPessoal/edicaoTarefa?id_tarefa=${c.id}" style="color: #6A5ACD">Editar Tarefa!</a></td>
	</tr>
</c:forEach>

</table>
<br>
<a href="/agendaPessoal/cadastroTarefa" class="linkespecial">Cadastrar nova Tarefa!</a>
<a href="/agendaPessoal/logout" class="linkespecial">Logout</a>
</div>
</body>
</html>