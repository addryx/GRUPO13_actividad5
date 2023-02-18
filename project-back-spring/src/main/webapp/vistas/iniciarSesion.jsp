<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesion</title>
</head>
<body>
	<p>${fallo}</p>
	<form action="/login" method="post">
		<label for="email"><i>Email:</i></label>
		<input type="text" name="email" id="email" required><br>
		<br>
		<label for="contrasena"><i>Contraseña:</i></label>
		<input type="password" name="contrasena" id="contrasena" required><br>
		<br>
		<button type="submit"><i>Entrar</i></button>
	</form>
</body>
</html>