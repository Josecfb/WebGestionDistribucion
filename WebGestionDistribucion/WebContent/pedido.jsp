<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión distribución</title>
<script src="js/pedido.js"></script>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>
	<nav class="menu">
    	 <a href="Principal"> <button class="botonm">Home</button></a>
        <a href="Pedidos"><button class="botonactivo">Pedidos</button></a>
        <a href="registro.jsp"><button class="botonm">Registro</button></a>
        <a href="iniciosesion.jsp"><button class="botonm">Iniciar Sesión</button></a>
	</nav>
	<h1>Gestion Distribución</h1>
	<p>${cli.nombre}</p>
	<form>
	<input type="text" class="campo" name="filtro" id="btfiltro">
	<input type="button"  class="botonm" value="Buscar" id="tfiltro"> 
	
	</form>
	<div class="listas">
		<ul>
		<c:forEach items="${artpedido}" var="articulo">
			<li class="nombre">${articulo}</li>
		</c:forEach>
		</ul>
	</div>
	
	<div class="listas">
		<form action="CreaPedido" method="post" accept-charset="utf-8">
			<table id="tablapedido">
				
			</table>
		</form>
		
	</div>
	
	<div id="principal">
	<%int i=0; %>
	<p id="totalfilas" class="listas">${artpedido.size()}</p>
	<c:forEach items="${artpedido}" var="articulo">
		
	    <div class="contenedorart">
	    	<table>
	    		<tr><td colspan="2"><p class="nombreart"></p></td></tr>
		        <tr><td class="colizq"><img class="imagenart"></td><td class="colder"><p class="precio"></p><p class="stock"></p></td></tr>
		        <tr><td colspan="2">
		        	<form>


	
			        	<input class="campoo" type="number" name="codart">
			        	Cantidad: <input class="campoc" type="number" name="cantidad" ><br>
			        	<input type="button" width="200px" class="botonm" value="pedir" id='<%=i%>'>
			        	<br><span class="error"></span>
			        	<%i++; %>

		
		        	</form>
		        </td></tr>
	        </table>
	    </div>
	</c:forEach>
	</div>
	<div class="menu" id="pags">

	</div>
	
</body>
</html>