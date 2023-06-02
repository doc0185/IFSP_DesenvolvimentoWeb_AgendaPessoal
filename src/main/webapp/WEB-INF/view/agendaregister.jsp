<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Registro de Usuário</title>
</head>
<body>

<h1>Registro de Usuário</h1>
<form action="<%=request.getContextPath() %>/register" method=post>
<table style="width=80%">
	<tr>
		<td>Login: </td>
		<td><input type="text" name="login"/></td>
	</tr>
	
	<tr>
		<td>Senha: </td>
		<td><input type="password" name="senha"/></td>
	</tr>
	
	<tr>
		<td>Nome: </td>
		<td><input type="text" name="nome"/></td>
	</tr>
	
	<tr>
		<td>Email: </td>
		<td><input type="text" name="email"/></td>
	</tr>

</table>
<input type="submit" value="Enviar"/>

</form>
<br>

<a href="/agendaPessoal/login">Já cadastrado?</a>

</body>
</html>