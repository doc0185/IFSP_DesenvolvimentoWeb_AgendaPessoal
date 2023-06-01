<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Login de Usuários</title>
</head>
<body>

<h1>Login de Usuários</h1>
<form action="<%=request.getContextPath() %>/login" method=post>
<table style="width=80%">
	<tr>
		<td>Login</td>
		<td><input type="text" name="login"/></td>
	</tr>
	
	<tr>
		<td>Senha</td>
		<td><input type="password" name="senha"/></td>
	</tr>
</table>
<input type="submit" value="Enviar"/>

</form>

</body>
</html>