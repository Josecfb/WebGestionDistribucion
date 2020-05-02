<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión distribución</title>
<script src="js/principal.js"></script>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>
	<nav class="menu">
    	  <button class="botonactivo">Home</button>
        <a href="Pedidos"><button class="botonm">Pedidos</button></a>
        <a href="registro.jsp"><button class="botonm">Registro</button></a>
        <a href="iniciosesion.jsp"><button class="botonm">Iniciar Sesión</button></a>
	</nav>
	<h1>Gestion Distribución</h1>
	<p id="mensaje">${mensaje}</p>
	<div class="listas">
		<ul>
		<c:forEach items="${articulos}" var="articulo">
			<li class="nombre${articulo.familiaBean.num}">${articulo.nombre};${articulo.cod}</li>
		</c:forEach>
		</ul>
	</div>
	<div id="principal">
	<c:forEach items="${familias}" var="familia">
		
	    <div class="contenedor">
	    	<h1>${familia.nombre}</h1>
	        <p class="titulo"></p>
	        <img class="imagen">
	        <div class="botones"></div>
	    </div>
	</c:forEach>
	</div>
</body>
</html>