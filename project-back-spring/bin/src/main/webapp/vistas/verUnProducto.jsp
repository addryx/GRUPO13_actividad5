<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${producto.nombre }</title>
</head>
<body>
	<h1>Datos Producto</h1>

	<p>${producto.idProducto }</p>
	<p>${producto.nombre }</p>
	<p>${producto.descripcion }</p>
	<p>${producto.precio }</p>
	<p>${producto.stock }</p>

</body>
</html>