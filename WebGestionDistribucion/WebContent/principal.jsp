<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión distribución</title>
<script src="js/codigo.js"></script>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>
	
	<h1>Gestion Distribución</h1>
	<div id="listas">
		<ul>
		<c:forEach items="${articulos}" var="articulo">
			<li class="nombre${articulo.familiaBean.num}">${articulo.nombre};${articulo.cod}</li>
		</c:forEach>
		</ul>
	</div>

	<c:forEach items="${familias}" var="familia">
		<h1>${familia.nombre}</h1>
	    <div class="contenedor">
	        <p class="titulo"></p>
	        <img class="imagen">
	        <div class="botones"></div>
	    </div>
	</c:forEach>
</body>
</html>