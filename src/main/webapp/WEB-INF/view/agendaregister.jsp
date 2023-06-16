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
		<h1>Formulario de Registro de Usuario</h1>

		<label>
			<span>Nome</span>
 			<input type="text" class="input_text" name="nome" id="name" required="required"/>

		</label>

		<label>
 			<span>Email</span>
			<input type="email" class="input_text" name="email" id="email" required="required"/>
		 </label>
		 
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

	<a href="/agendaPessoal/login" >Já cadastrado?</a>
	
	</div>


</body>
</html>