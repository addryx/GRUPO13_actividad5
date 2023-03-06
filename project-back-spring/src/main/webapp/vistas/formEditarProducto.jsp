<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar producto</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<h3>EDITAR PRODUCTO</h3>
	<form action="/producto/editar" method="post">
		<label for="idProducto">Id Producto</label>
		<input type="text" name="idProducto" value="${producto.idProducto }"><br>
		<br>
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre" value="${producto.nombre }"><br>
		<br>
		<label for="descripcion">Descripción</label>
		<input type="text" name="descripcion" value="${producto.descripcion }"><br>
		<br>
		<label for="precio">Precio</label>
		<input type="number" name="precio" value="${producto.precio }"><br>
		<br>
		<label for="stock">Stock</label>
		<input type="text" name="stock" value="${producto.stock }"><br>
		<br>
		<input type="submit" value="Guardar">
	</form>
	
</body>
</html>