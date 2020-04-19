
window.addEventListener("load",programa);


var imagen=new Array();
var titulo=new Array();
var botones=new Array();
var total;
var totales=new Array();
var i=new Array();
var articulo=new Array();
var radios=new Array();

function iniciaTodo(){
	imagen=document.getElementsByClassName('imagen');
	titulo=document.getElementsByClassName('titulo');
	botones=document.getElementsByClassName('botones');
	total=titulo.length;

	for (l=0;l<total;l++){
		i[l]=-1; 
		console.log(l);
		articulo[l]=document.getElementsByClassName('nombre'+(l+1));
		totales[l]=articulo[l].length;
		for (b=0;b<totales[l];b++){
			botones[l].innerHTML+='<input type="radio" class="boton" name="boton'+l+'" id="rad">';
			console.log('<input type="radio" class="boton" id="rad">');
			console.log(l);
			
		}
		radios[l]=document.getElementsByName('boton'+l);
		
	}
}

function avanza(){
	for (l=0;l<total;l++){
		i[l]++;
		if (i[l]==totales[l]) i[l]=0;
		console.log(l+" "+i[l]);
		ponFoto(i[l],l);
	}
}

function programa(){
    iniciaTodo();
    avanza();
    setInterval(avanza,40000);
}

function ponFoto(fo,l){
	
	console.log(l+" "+fo+" "+articulo[l][fo].textContent);
    imagen[l].src="fotos/"+articulo[l][fo].textContent.split(";")[1]+".jpg"; 
    titulo[l].innerHTML=articulo[l][fo].textContent.split(";")[0];
    radios[l][fo].ckecked=true;
}