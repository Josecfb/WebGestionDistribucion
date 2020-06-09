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
	<table id="tbusca" class="tablaform">
		<tr>
			<td>
				<input type="text" class="campo" name="filtro" id="tfiltro">
				<input type="button"  class="botonm" value="Buscar" id="btfiltro"> 
			</td>
			<td class="colderecha"><img alt="" src="img/usuario.png"></td><td class="corder">${cli.nombre} ${cli.apellidos}</td>
			<td class="colderecha"><input type="button" id="benpedido"  value=" en pedido"><input type="button" id="bseguir" value="Añadir mas artículos"></td>
		</tr>
	</table>
	
	
	<div class="listas">
		<ul>
		<c:forEach items="${artpedido}" var="articulo">
			<li class="nombre">${articulo}</li>
		</c:forEach>
		</ul>
	</div>
	
	
	
	<div id="principal">
	<%int i=0; %>
	<p id="totalfilas" class="listas">${artpedido.size()}</p>
	
	<c:forEach items="${artpedido}" var="articulo">
	    <div class="contenedorart">
	    	<table>
	    		<tr><td colspan="2"><h3 class="nombreart"></h3></td></tr>
		        <tr><td class="colizq"><img class="imagenart"></td><td class="colder"><p class="precio"></p><p class="stock"></p><p class="veces"></p> </td></tr>
		        <tr><td colspan="2">
		        	<input class="campoo" type="number" name="codart">
		        	Cantidad: <input class="campoc" type="number" name="cantidad" >
		        	<input type="button" width="200px" class="botonp" value="pedir" id='<%=i%>'>
		        	<br><span class="error"></span><span class="aviso"></span>
		        	
		        	<%i++; %>
		        </td></tr>
	        </table>
	    </div>
	</c:forEach>
	</div>
	
	<div id="verpedido">
		<h1>Artículos en el pedido actual</h1>
		<table id="pedido">
		<tr><th>Código</th><th>Descripción</th><th>Cantidad</th><th>Precio</th><th>Total</th></tr>
		</table>
		<div>
			
			
			<form action="CreaPedido" method="post" accept-charset="utf-8">
				<div class="listas">
				<input type="text" name="numcli" value="${cli.numero}">
				<input type="text" name="filaspedido" id="filaspedido">
				</div>
				
				<input type="submit" class="botonm" id="btramitar" value="Tramitar pedido">
			</form>
			
		</div>
	</div>
	
</body>
</html>