<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/codigo.js"></script>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>
	
	<h1>Gestion Distribución</h1>
	<div id="listas">
		<ul>
		<c:forEach items="${listaNombres1}" var="nombre1">
			<li class="nombre1">${nombre1}</li>
		</c:forEach>
		</ul>
		<ul>
		<c:forEach items="${listaFotos1}" var="foto1">
			<li class="foto1">${foto1}</li>
		</c:forEach>
		</ul>
	</div>
    <div id="contenedor">
        <p id="titulo"></p>
        <img id="imagen">
        <div id="botones"></div>
        <div class="direccion" id="izq"><img id="imagI" class="mini"></div>
        <div class="direccion" id="der"><img id="imagD" class="mini"></div>
    </div>
</body>
</html>