<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Registro de Usuário</title>
<style><%@include file="/WEB-INF/view/style.css"%></style>
</head>
<body>

<div class="box">
<form action="<%=request.getContextPath() %>/register" method=post id="formulario">
		<h1>Formulario de Regsitro de Usuario</h1>

		<label>
			<span>Nome</span>
 			<input type="text" class="input_text" name="nome" id="name"/>

		</label>

		<label>
 			<span>Email</span>
			<input type="text" class="input_text" name="email" id="email"/>
		 </label>
		 
		 <label>
 			<span>Login</span>
			<input type="text" class="input_text" name="login" id="login"/>
		</label>

		<label>
 			<span>Senha</span>
			<input type="password" class="input_text" name="senha" id="senha"/>
		</label>

		<label>
			<input type="submit" class="button" value="Enviar" />
		</label>
</form>

	<a href="/agendaPessoal/login" >Já logado? Clique aqui</a>
	

	</div>


</body>
</html>