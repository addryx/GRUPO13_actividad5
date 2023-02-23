<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 class="users"> Listado de usuarios</h1>
		
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Fecha de nacimiento</th>
			<th>Email</th>
			<th>Opciones</th>
		</tr>

		<c:forEach var="ele" items="${listaTodos }">
			
		<tr>
			<td>${ele.idUsuario }</td>
			<td>${ele.nombre }</td>
			<td>${ele.apellidos }</td>
			<td>${ele.fechaNacimiento }</td>
			<td>${ele.email }</td>
			<td><a href="/app/producto/eliminar/${ele.idUsuario}" class="btn btn-delete">Eliminar</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>