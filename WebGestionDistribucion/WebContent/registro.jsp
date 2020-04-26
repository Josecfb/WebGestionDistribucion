<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Gestión distribución</title>
<script src="js/codigo.js"></script>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>
	<nav id="menu">
    	<a href="Principal"><button class="botonm">Home</button></a>
        <a href="ControladorListadoProductos"><button class="botonm">Pedidos</button></a>
        <a href="alta.jsp"><button class="botonactivo">Registro</button></a>
        <a href="buscar.jsp"><button class="botonm">Modificar</button></a>
        <a href="eliminar.jsp"><button class="botonm">Eliminar</button></a>
	</nav>
	<h1>Registro nuevo usuario</h1>
	<form action="AltaCliente" method="post" accept-charset="utf-8">
		<table>
			<tr>
				<td class="td1">Nombre:</td><td> <input type="text" class="campo" name="nombre" value="${cli.nombre}" maxlength="20"/><br/><span>${error[0]}</span></td>
				<td class="td1">Apellidos:</td><td><input type="text" class="campo" name="apellidos" maxlength="20" value="${cli.apellidos}"/><br/><span>${error[1]}</span></td>
			</tr>
			<tr>
				<td class="td1">NIF:</td><td><input type="text" class="campo" name="nif" maxlength="9" value="${cli.nifCif}"/><br/><span>${error[2]}</span></td>
				<td class="td1">Email:</td><td><input type="email" class="campo" name="email" maxlength="30" value="${cli.email}"/><br/><span>${error[3]} ${error[10]}</span></td>
			<tr/>
			<tr>
				<td class="td1">Contraseña:</td><td><input type="password" class="campo" name="pass1" value=""/><br/><span>${error[7]}</span></td>
				<td class="td1">Confirme contraseña:</td><td><input type="password" class="campo" name="pass2" value=""/><br/><span>${error[8]}</span></td>
			<tr/>
			<tr>
				<td class="td1">Dirección:</td><td colspan="3"><input type="text" class="campol" name="direccion" maxlength="40" value="${cli.direccion}"><br/><span>${error[4]}</span></td> 
			<tr/>
			<tr>
				<td class="td1">Cod.Postal:</td><td><input type="number" class="campo" name="codpost" maxlength="5" value="${cli.codPost}"/><br/><span>${error[6]}</span></td>
				<td class="td1">Población:</td><td><input type="text" class="campo" name="poblacion" maxlength="40" value="${cli.poblacion}"/><br/><span>${error[5]}</span></td>
			<tr/>
			<tr>
				<td class="td1">Tlfn. Fijo:</td><td><input type="number" class="campo" name="fijo" maxlength="9" value="${cli.telefonoFijo}"/><br/></td>
				<td class="td1">Tlfn. Móvil:</td><td><input type="number" class="campo" name="movil" maxlength="9" value="${cli.telefonoMovil}"/><br/><span>${error[2]}</span></td>
			<tr/>
			<tr>
				<td colspan="2" ALIGN="right"><input type="submit" value="ALTA" class="botonm" style="width:100px"/></td>
				<td colspan="2" ><input type="reset" value="LIMPIAR" class="botonm" id="borrar" style="width:100px"/></td>
			</tr>
			<tr><td><p> </p></td></tr>
				
		</table>
		<span>${error[9]}</span>
		<br/>
		
	</form>
	
</body>
</html>