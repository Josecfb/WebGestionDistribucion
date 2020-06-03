/**
 * Destiona tramitación de pedido pedido
 */
window.addEventListener("load",programa);
var imagen=new Array();
var titulo=new Array();
var total;
var articulo=new Array();
var contenedorart=new Array();

var pCod=new Array();
var pPrecio=new Array();
var pCantidad=new Array();
var pNom=new Array();
var cadFilasPed="";

function iniciaTodo(){
	total=totalfilas.textContent;
	
	imagen=document.getElementsByClassName('imagenart');
	titulo=document.getElementsByClassName('nombreart');
	precio=document.getElementsByClassName('precio');
	stock=document.getElementsByClassName('stock');
	veces=document.getElementsByClassName('veces');
	cantidad=document.getElementsByClassName('campoc');
	codarti=document.getElementsByClassName('campoo');
	error=document.getElementsByClassName('error');
	contenedorart=document.getElementsByClassName('contenedorart');
	aviso=document.getElementsByClassName('aviso');

	articulo=document.getElementsByClassName('nombre');
	botonp=document.getElementsByClassName('botonp');
	for (l=0;l<total;l++){
		imagen[l].src="fotos/"+articulo[l].textContent.split(";")[0]+".jpg";
		titulo[l].innerHTML=articulo[l].textContent.split(";")[1];
		precio[l].innerHTML="Precio unitario: "+articulo[l].textContent.split(";")[2].split(".")[0]+","+articulo[l].textContent.split(";")[2].split(".")[1]+" €";
		stock[l].innerHTML="Stock: "+articulo[l].textContent.split(";")[3];
		if (articulo[l].textContent.split(";")[4]!="null") veces[l].innerHTML="Pedido "+articulo[l].textContent.split(";")[4]+" veces";
		cantidad[l].max=articulo[l].textContent.split(";")[3];
		codarti[l].value=articulo[l].textContent.split(";")[0];
		botonp[l].addEventListener("click",agregar); 
	}
	btfiltro.addEventListener("click",filtrar);
	benpedido.addEventListener("click",mostrarPedido);
	bseguir.addEventListener("click",seguir);
	btramitar.addEventListener("click",tramitar);
}

function tramitar(){
	
}

function filtrar(){
	seguir();
	console.log(total);
	for (l=0;l<total;l++){
		console.log(titulo[l].textContent.includes(document.getElementById('tfiltro').value));
		if (!titulo[l].textContent.toUpperCase().includes(document.getElementById('tfiltro').value.toUpperCase())){
			console.log("oculta");
			contenedorart[l].style.display="none";
		}
		else
			contenedorart[l].style.display="inline-block";
	}
}

function mostrarPedido(){
	totalped=0;
	cadFilasPed="";
	document.getElementById('pedido').innerHTML="<tr><th>Código</th><th>Descripción</th><th>Cantidad</th><th>Precio</th><th>Total</th></tr>";
	for (i=0;i<pCantidad.length;i++){
		totalped+=pCantidad[i]*pPrecio[i];
		document.getElementById('pedido').innerHTML+="<tr>" +
		"<td>"+pCod[i]+"</td>" +
		"<td>"+pNom[i]+"</td>"+
		"<td>"+pCantidad[i]+"</td>" +
		"<td>"+pPrecio[i]+" €</td>"+
		"<td>"+Math.round(pCantidad[i]*pPrecio[i]*100)/100+" €</td></tr>";
		cadFilasPed+=pCod[i]+";"+pCantidad[i]+";"+pPrecio[i]+"#";
	}
	document.getElementById('filaspedido').value=cadFilasPed;
	document.getElementById('pedido').innerHTML+="<tr>" +
			"<td colspan='3'><td>Base</td><td>"+Math.round(totalped*100)/100+" €</td></tr>";
	document.getElementById('pedido').innerHTML+="<tr>" +
			"<td colspan='3'><td>IVA</td><td>"+Math.round(totalped*100*0.1)/100+" €</td></tr>";
	document.getElementById('pedido').innerHTML+="<tr>" +
			"<td colspan='3'><td>Total</td><td>"+Math.round(totalped*100*1.1)/100+" €</td></tr>"
	verpedido.style.display="block";
	principal.style.display="none";
	bseguir.style.display="block";
	benpedido.style.display="none";
}

function seguir(){
	verpedido.style.display="none";
	principal.style.display="block";
	bseguir.style.display="none";
	benpedido.style.display="block";
}

function agregar(){
	console.log(parseInt(articulo[this.id].textContent.split(";")[3],10));
	if (cantidad[this.id].value=="" || cantidad[this.id].value==0)
		error[this.id].innerHTML="Selecione una cantidad mayor de 0";
	else 
		if (cantidad[this.id].value>parseInt(articulo[this.id].textContent.split(";")[3],10))
			error[this.id].innerHTML="No puede pedir mas de "+articulo[this.id].textContent.split(";")[3];
		else {
			pCod.push(parseInt(articulo[this.id].textContent.split(";")[0],10));
			pNom.push(articulo[this.id].textContent.split(";")[1]);
			pCantidad.push(cantidad[this.id].value);
			pPrecio.push(parseFloat(articulo[this.id].textContent.split(";")[2]));
			
			error[this.id].innerHTML="";
			aviso[this.id].innerHTML="Se han agregado "+cantidad[this.id].value+" unidades de "+articulo[this.id].textContent.split(";")[1];
			suma=0;
			for (i=0;i<pCantidad.length;i++){
				suma+=Number.parseInt(pCantidad[i],10);
				
			}
		benpedido.value=suma+" en pedido"
		
	}
	cantidad[this.id].value="";
}

function programa(){
    iniciaTodo();
}
