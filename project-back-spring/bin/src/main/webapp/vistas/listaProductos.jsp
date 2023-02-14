<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<jsp:include page="inicio.jsp"></jsp:include>

	<div class="container">
		<h1 class="text-primary">Lista de productos</h1>
		<sec:authorize access="hasAnyAuthority('ROLE_GESTOR','ROLE_ADMINISTRADOR')">
			<a href="/app/producto/alta" class="btn btn-primary btn-sm">Nuevo Producto</a>
		</sec:authorize>
		
		<table class="table table-striped table-sm">
			<tr>
				<th>Id</th>
				<th>Descripcion</th>
				<th>Opciones</th>
			</tr>

			<c:forEach var="ele" items="${listaTodos }">
				<tr>
					<td>${ele.codigo }</td>
					<td>${ele.descripcion }</td>
					<td>
						<a href="/app/producto/verUno/${ele.codigo}" class="btn btn-success btn-sm">Ver detalle</a> 
						<sec:authorize access="hasAnyAuthority('ROLE_GESTOR','ROLE_ADMINISTRADOR')">
							<a href="/app/producto/editar/${ele.codigo}" class="btn btn-success btn-sm">Modificar</a>
							<a href="/app/producto/eliminar/${ele.codigo}" class="btn btn-danger btn-sm">Eliminar</a>
						</sec:authorize>
					</td>
						
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