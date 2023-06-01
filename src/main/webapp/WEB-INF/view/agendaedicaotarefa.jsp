<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Tarefas</title>
</head>
<body>
<h1>Edição de Tarefas</h1>
<form action="<%=request.getContextPath() %>/edicaoTarefa" method=post>
<table style="width=80%">
	<tr>
		<td>Titulo</td>
		<td><input type="text" name="titulo" value=<%= request.getAttribute("titulo") %>></td>
	</tr>
	
	<tr>
		<td>Descricao</td>
		<td><input type="text" name="descricao" value=<%= request.getAttribute("descricao") %>></td>
	</tr>
	
	<tr>
		<td>Data Início</td>
		<td><input type="date" name="data_inicio" value=<%= request.getAttribute("data_inicio") %> min="2023-05-25" max="2023-12-31"></td>
	</tr>
	
	<tr>
		<td>Data Conclusão</td>
		<td><input type="date" name="data_conclusao" value=<%= request.getAttribute("data_conclusao") %> min="2023-05-25" max="2023-12-31"></td>
	</tr>
	
	<tr>
		<td>Status</td>
		<td><input type="text" name="status" value=<%= request.getAttribute("status") %>></td>
	</tr>
	
	
</table>
<input type="submit" value="Enviar"/>

</form>
</body>
</html>