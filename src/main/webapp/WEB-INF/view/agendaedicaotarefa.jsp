<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de Tarefas</title>
<style><%@include file="/WEB-INF/view/style3.css"%></style>

</head>

<body>
<div class="box">

	<form action="<%=request.getContextPath() %>/edicaoTarefa" method=post>
	<h1>Edição de Tarefas</h1>
	<h2> Dados Obrigatórios: Título, Descrição, Data Início e Data de Conclusão</h2>
	<label>
			<span>Titulo</span>
 			<input type="text" class="input_text" name="titulo" id="titulo" required="required" value=<%= request.getAttribute("titulo") %>>
	</label>
	
	<label>
			<span>Descricao</span>
 			<input type="text" class="input_text" name="descricao" id="descricao" required="required" value=<%= request.getAttribute("descricao") %>>
	</label>
	
	<label>
			<span>Data Início</span>
 			<input type="date" class="input_text" name="data_inicio" id="data_inicio" required="required" value=<%= request.getAttribute("data_inicio") %> min="2023-05-25" max="2023-12-31">
	</label>
	
	<label>
			<span>Data Conclusao</span>
 			<input type="date" class="input_text" name="data_conclusao" id="data_conclusao" required="required" value=<%= request.getAttribute("data_conclusao") %> min="2023-05-25" max="2023-12-31">
	</label>
	
	<label>
			<span>Status</span>
 			<input type="text" class="input_text" name="status" id="status" value=<%= request.getAttribute("status") %>>
	</label>
	
	<label>
			<input type="submit" class="button" value="Enviar" />
		</label>
	
	</form>
	
	
</div>
</body>
</html>