<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta producto</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<h3>ALTA PRODUCTO</h3>
	<form action="/producto/alta" method="post">
		<label for="idProducto">Id Producto</label>
		<input type="text" name="idProducto"><br>
		<br>
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre"><br>
		<br>
		<label for="descripcion">Descripción</label>
		<input type="text" name="descripcion"><br>
		<br>
		<label for="precio">Precio</label>
		<input type="number" name="precio"><br>
		<br>
		<label for="stock">Stock</label>
		<input type="text" name="stock"><br>
		<br>
		<input type="submit" value="Alta">
	</form>
	
</body>
</html>