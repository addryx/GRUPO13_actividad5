<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar cliente</title>
</head>
<body>
	<h1>Registro de clientes nuevos:</h1>
    <h1>${mensaje }</h1>
    <form action="/registro" method="post">
        <input type="text" name="nombre" placeholder="Nombre"> 
        <input type="text" name="apellidos" placeholder="Apellidos"> 
       	<input type="date" name="fechaNacimiento" placeholder="Fecha Nacimiento"> 
       	<input type="text" name="email" placeholder="Email"> 
        <input type="password" name="contrasena" placeholder="Contraseña"> 
        
        <input type="submit" value="Registrar">
    </form>
</body>
</html>