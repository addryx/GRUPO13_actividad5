<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="home.jsp"></jsp:include>
	<br>
	<h3>REGÍSTRATE</h3>
	<h1>${mensaje }</h1>
	<br>
	<form action="/registro" method="post">
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre" placeholder="Nombre" required><br>
		<br>
		<label for="apellidos">Apellidos</label>
		<input type="text" name="apellidos" placeholder="Apellidos" required><br>
		<br>
		<label for="fechaNacimiento">Fecha de nacimiento</label>
		<input type="date" name="fechaNacimiento" required><br>
		<br>
		<label for="email">Correo electrónico</label>
		<input type="email" name="email" placeholder="email@email.com" required><br>
		<br>
		<label for="contrasena">Contraseña</label>
		<input type="password" name="contrasena" placeholder="Contraseña" required><br>
		<br>
		<input type="submit" value="Registrar">
	</form>
</body>
</html>