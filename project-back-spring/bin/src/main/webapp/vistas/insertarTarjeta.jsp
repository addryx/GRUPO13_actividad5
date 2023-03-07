<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de tarjetas</title>
</head>
<body>
	<h1>FORMULARIO PARA DAR DE ALTA UNA NUEVA TARJETA</h1>
	<form action="usuario/tarjeta/darAltaTarjeta" method="post">
		<p><input type="number" name="numeroTarjeta">Número de la tarjeta: </p>
		<p><input type="text" name="nombreTitular">Nombre del titular: </p>
		<p><input type="date" name="fechaCaducidad">Fecha de caducidad: </p>
		<p><input type="number" name="cvv">CVV: </p>
		
		<p><input type="submit" value="Enviar"></p>
	</form>
</body>
</html>