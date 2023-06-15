<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Tarefas</title>
<style><%@include file="/WEB-INF/view/style3.css"%></style>
</head>

<body>
<div class="box">

	<form action="<%=request.getContextPath() %>/cadastroTarefa" method=post>
	<h1>Cadastro de Tarefas</h1>
	
	<label>
			<span>Titulo</span>
 			<input type="text" class="input_text" name="titulo" id="titulo"/>
	</label>
	
	<label>
			<span>Descricao</span>
 			<input type="text" class="input_text" name="descricao" id="descricao"/>
	</label>
	
	<label>
			<span>Data Início</span>
 			<input type="date" class="input_text" name="data_inicio" id="data_inicio" value="2023-05-25" min="2023-05-25" max="2023-12-31"/>
	</label>
	
	
	<label>
			<span>Data Conclusão</span>
 			<input type="date" class="input_text" name="data_conclusao" id="data_conclusao" value="2023-05-25" min="2023-05-25" max="2023-12-31"/>
	</label>
	
	<label>
			<span>Status</span>
 			<input type="text" class="input_text" name="status" id="status"/>
	</label>
	
	<label>
			<input type="submit" class="button" value="Enviar" />
		</label>
	
	</form>
<!-- 
<form action="<%=request.getContextPath() %>/cadastroTarefa" method=post>
<table style="width=80%">
	<tr>
		<td>Titulo</td>
		<td><input type="text" name="titulo"/></td>
	</tr>
	
	<tr>
		<td>Descricao</td>
		<td><input type="text" name="descricao"/></td>
	</tr>
	
	<tr>
		<td>Data Início</td>
		<td><input type="date" name="data_inicio" value="2023-05-25" min="2023-05-25" max="2023-12-31"></td>
	</tr>
	
	<tr>
		<td>Data Conclusão</td>
		<td><input type="date" name="data_conclusao" value="2023-05-25" min="2023-05-25" max="2023-12-31"></td>
	</tr>
	
	<tr>
		<td>Status</td>
		<td><input type="text" name="status"/></td>
	</tr>
	
	
</table>
<input type="submit" value="Enviar"/>

</form>
 -->
</div>
</body>
</html>