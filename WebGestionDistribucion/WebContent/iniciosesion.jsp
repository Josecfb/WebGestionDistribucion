<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Gestión distribución</title>
<script src="js/iniciosesion.js"></script>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>
	<nav class="menu">
    	<a href="Principal"><button class="botonm">Home</button></a>
        <a href="Pedidos"><button class="botonm">Pedidos</button></a>
        <a href="registro.jsp"><button class="botonm">Registro</button></a>
        <a href="buscar.jsp"><button class="botonactivo">Iniciar Sesión</button></a>
	</nav>
	<h1>Iniciar sesión</h1>
	<p id="mensaje">${mensaje}</p>
	<form action="InicioSesion" method="post" accept-charset="utf-8">
		<table class="tablaform">
			<tr>
				<td class="td1">Email:</td><td> <input type="text" class="campo" name="email" maxlength="30"/><br/><span>${error[0]}</span></td>
				<td class="td1">Contraseña:</td><td><input type="password" class="campo" name="password" maxlength="20"/><br/><span>${error[1]}</span></td>
			</tr>
			<tr>
				<td colspan="2" ALIGN="right"><input type="submit" value="INICIAR" class="botonm" style="width:100px"/></td>
				<td colspan="2" ><input type="reset" value="LIMPIAR" class="botonm" id="borrar" style="width:100px"/></td>
			</tr>
			<tr><td><p> </p></td></tr>
				
		</table>
		<span>${error[2]}</span>
		<br/>
		
	</form>
	
</body>
</html>