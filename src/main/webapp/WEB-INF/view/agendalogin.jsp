<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Login de Usuários</title>
<style><%@include file="/WEB-INF/view/style.css"%></style>
</head>
<body>

<div class="box">
	<form action="<%=request.getContextPath() %>/login" method=post>
	<h1>Formulario de Login</h1>

		<label>
 			<span>Login</span>
			<input type="text" class="input_text" name="login" id="login" required="required"/>
		</label>

		<label>
 			<span>Senha</span>
			<input type="password" class="input_text" name="senha" id="senha" required="required"/>
		</label>

		<label>
			<input type="submit" class="button" value="Enviar" />
		</label>
	
	</form>
</div>
</body>
</html>