<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta usuario</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="home.jsp"></jsp:include>

	<h3>ALTA USUARIO</h3>
	<form action="/usuario/alta" method="post">
		<label for="role">Role</label>
		<input type="text" name="role" value="ROLE_ADMON" required disabled><br>
		<br>
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre" required><br>
		<br>
		<label for="apellidos">Apellidos</label>
		<input type="text" name="apellidos" required><br>
		<br>
		<label for="fechaNacimiento">Fecha nacimiento</label>
		<input type="date" name="fechaNacimiento" required><br>
		<br>
		<label for="email">Email</label>
		<input type="email" name="email" required><br>
		<br>
		<label for="contrasena">Contraseña</label>
		<input type="password" name="contrasena" required><br>
		<br>
		<input type="submit" value="Alta">
	</form>
	
</body>
</html>