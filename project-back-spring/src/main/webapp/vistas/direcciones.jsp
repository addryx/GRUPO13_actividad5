<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Direcciones</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<br>
		<h1 class="text-primary">Listado de direcciones</h1>
		<h1>${mensaje }</h1>

			<a href="/producto/alta" class="btn btn-primary btn-sm">Nueva direcci?n</a>
			<br>
			</td>
			<br>

		<table class="table table-striped table-sm">
			<th>Id direccion</th>
			<th>Nombre</th>
			<th>Id Producto</th>
			<th>Nombre</th>
			<th>Id Producto</th>
			<th>Nombre</th>
			<th></th>
			<th></th>
			<c:forEach var="ele" items="${listaTodosProductos }">
				<tr>
					<td>${ele.idProducto }</td>
					<td>${ele.nombre }</td>
					<td><a href="/producto/verDetalle/${ele.idProducto}" class="btn btn-success btn-sm">Ver detalle</a> 
					<td><a href="/producto/carrito/${ele.idProducto}" class="btn btn-success btn-sm">A?adir carrito</a>
					
					<sec:authorize access="hasAnyAuthority('ROLE_ADMON')">
							<a href="/producto/editar/${ele.idProducto}" class="btn btn-success btn-sm">Editar</a>
							<a href="/producto/eliminar/${ele.idProducto}" class="btn btn-danger btn-sm">Eliminar</a>
							</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>