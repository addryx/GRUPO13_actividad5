<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de tarjetas</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1>REGISTRAR NUEVA TARJETA</h1>
	<form action="/darAltaTarjeta" method="post">
		
		<label for="numero-tarjeta">Nº Tarjeta: </label>
		<input type="number" name="numeroTarjeta" required autofocus><br>
		<br>
		<label for="nombre-titular">Nombre del titular: </label>
		<input type="text" name="nombreTitular" required><br>
		<br>
		<label for="fecha-caducidad">Fecha de Caducidad: </label>
		<input type="date" name="fechaCaducidad" required><br>
		<br>
		<label for="codigo-verificacion">CVV: </label>
		<input type="number" name="cvv" required><br>
		
		<input type="submit" value="Añadir tarjeta">
	</form>
</body>
</html>