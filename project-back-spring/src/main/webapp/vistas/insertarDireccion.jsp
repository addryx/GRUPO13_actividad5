<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de direcciones</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<h1>AÑADIR UNA NUEVA DIRECCIÓN</h1>
	<form action="/darAltaDireccion" method="post">
	
		<label for="codigo-postal">CP: </label>
		<input type="text" name="codigoPostal" required autofocus><br>
		<br>
		<label for="localidad">Localidad: </label>		
		<input type="text" name="localidad" required><br>
		<br>
		<label for="calle">Calle: </label> 
		<input type="text" name="calle" required><br>
		<br>
		<label for="numero">Número: </label>
		<input type="number" name="numero" required><br>
		<br>
		<label for="piso">Piso: </label>
		<input type="number" name="piso" required><br>
		<br>
		<label for="letra">Letra: </label>
		<input type="text" name="letra" required><br>
		<br>
		<input type="submit" value="Añadir dirección">
	</form>
</body>
</html>