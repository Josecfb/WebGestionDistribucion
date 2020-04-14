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
	<div>
		<ul id="nombres">
		<c:forEach items="${listaNombres}" var="nombre">
			<li class="nombre">${nombre}</li>
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