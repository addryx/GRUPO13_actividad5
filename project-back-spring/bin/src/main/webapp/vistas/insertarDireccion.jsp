<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de direcciones</title>
</head>
<body>
	<h1>FORMULARIO PARA AÑADIR UNA NUEVA DIRECCIÓN</h1>
	<form action="usuario/direccion/darAltaDireccion" method="post">
		<p><input type="text" name="codigoPostal">CP: </p>
		<p><input type="text" name="localidad">Localidad: </p>
		<p><input type="text" name="calle">Calle: </p>
		<p><input type="number" name="numero">Número: </p>
		<p><input type="number" name="piso">Piso: </p>
		<p><input type="text" name="letra">Letra: </p>
		
		<p><input type="submit" value="Enviar"></p>
	</form>
</body>
</html>