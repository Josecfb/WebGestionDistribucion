window.addEventListener("load",programa);
var imagen=new Array();
var titulo=new Array();
var total;
var articulo=new Array();

var pCod=new Array();
var pPrecio=new Array();
var pCantidad=new Array();
var paginas;
var pag;

function iniciaTodo(){
	total=totalfilas.textContent;
	
	imagen=document.getElementsByClassName('imagenart');
	titulo=document.getElementsByClassName('nombreart');
	precio=document.getElementsByClassName('precio');
	stock=document.getElementsByClassName('stock');
	cantidad=document.getElementsByClassName('campoc');
	codarti=document.getElementsByClassName('campoo');
	error=document.getElementsByClassName('error');
	
	paginas=Math.trunc(total/10)+1;
	articulo=document.getElementsByClassName('nombre');
	botonm=document.getElementsByClassName('botonm');
	for (l=0;l<total;l++){
		imagen[l].src="fotos/"+articulo[l].textContent.split(";")[0]+".jpg";
		titulo[l].innerHTML=articulo[l].textContent.split(";")[1];
		precio[l].innerHTML="Precio unitario: "+articulo[l].textContent.split(";")[2].split(".")[0]+","+articulo[l].textContent.split(";")[2].split(".")[1]+" €";
		stock[l].innerHTML="Stock: "+articulo[l].textContent.split(";")[3];
		cantidad[l].max=articulo[l].textContent.split(";")[3];
		codarti[l].value=articulo[l].textContent.split(";")[0];
		botonm[l].addEventListener("click",agregar); 
	}
	for (p=1;p<=paginas;p++)
		pags.innerHTML+="<input type='button' width='100px' class='botonp' value='"+p+"' id='"+p+"'>";
	btfiltro.addEventListener("click",filtrar);
}

function filtrar(){
	for (l=0;l<total;l++)
		if (articulo[l].textContent.split(";")[1].includes(tfiltro.testContent)){
			imagen[l].src="fotos/"+articulo[l].textContent.split(";")[0]+".jpg";
			titulo[l].innerHTML=articulo[l].textContent.split(";")[1];
			precio[l].innerHTML="Precio unitario: "+articulo[l].textContent.split(";")[2].split(".")[0]+","+articulo[l].textContent.split(";")[2].split(".")[1]+" €";
			stock[l].innerHTML="Stock: "+articulo[l].textContent.split(";")[3];
			cantidad[l].max=articulo[l].textContent.split(";")[3];
			codarti[l].value=articulo[l].textContent.split(";")[0];
			botonm[l].addEventListener("click",agregar); 
		}
	
}

function agregar(){
	console.log(this.id);
	console.log("Código: "+articulo[this.id].textContent.split(";")[0]);
	console.log("Nombre: "+articulo[this.id].textContent.split(";")[1]);
	console.log("Precio: "+articulo[this.id].textContent.split(";")[2]);
	console.log("Cantidad: "+cantidad[this.id].value);
	if (cantidad[this.id].value=="" || cantidad[this.id].value==0)
		error[this.id].innerHTML="Selecione una cantidad";
	else {
		pCod.push(articulo[this.id].textContent.split(";")[0]);
		pPrecio.push(articulo[this.id].textContent.split(";")[2]);
		pCantidad.push(cantidad[this.id].value);
	}
}

function creaFila(){
	
}


function programa(){
    iniciaTodo();
  
}
