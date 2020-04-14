var nombFoto=new Array(14); //Variable glogal para los nombres de las fotos
var total=nombFoto.length; //Longitud del array de nombres de fotos
var i=-1; //variable global para el indice de los arrays
// Array con los títulos de las fotos
var descripcion=document.getElementsByClassName('nombre');
//elecuta la función programa cuando la página está cargada
window.addEventListener("load",programa);

function iniciaTodo(){
    for (f=0;f<total;f++){
        nombFoto[f]="images/alhambra("+f+").jpg"; // asigna los nombres de las fotos al array nombFoto
        botones.innerHTML+='<input type="radio" name="boton" id="rad">'; //Pinta los radio buttons
     }
     //asigna el evento click a cada radio button llamando a la función comprueba
     for(r=0;r<total;r++)
        rad[r].addEventListener("click",comprueba); 
    izq.addEventListener("click",retrocede); // al hacer click en la imagen izquierda llama a la funcion retrocede
    der.addEventListener("click",avanza);  // al hacer click en la imagen derecha llama a la funcion avanza
    izq.addEventListener("mouseover",cambiaColor); // al situar el ratón sobre la imagen izquierda llama a la funcion cambiaColor
    der.addEventListener("mouseover",cambiaColor); // al situar el ratón sobre la imagen derecha llama a la funcion cambiaColor
    izq.addEventListener("mouseout",cambiaColor); // al situar el ratón fuera de la imagen izquierda llama a la funcion cambiaColor
    der.addEventListener("mouseout",cambiaColor); // al situar el ratón fuera de la imagen derecha llama a la funcion cambiaColor
    contenedor.addEventListener("mouseover",cambiaWidth); //al situar el ratón sobre el contenedor llama a la función cambiaWidth
    contenedor.addEventListener("mouseout",cambiaWidth); //al situar el ratón fuera del contenedor llama a la función cambiaWidth
}
// recorre el array de radiobuttons, y asigna a la variable global i el indice del radiobutton que esté marcado
// a continuación llama a la función ponFoto pasandole el indice i
function comprueba(){
    for(var r=0;r<total;r++)
        if(rad[r].checked){
            i=r;
            break;
        }
    ponFoto(i);
}
//incrementa en uno la variable global i. Si i alcanza el tamaño del array le asigna 0 para ir a la primera imagen
// a continuación llama a la función ponFoto pasandole el indice i
function avanza(){
    i++; 
    if (i===total) i=0;
    ponFoto(i);
}
//decrementa en uno la variable global i. Si i alcanza un malor menor que cero le asigna total-1 para ir a la última imagen
// a continuación llama a la función ponFoto pasandole el indice i
function retrocede(){
    i--;
    if(i<0)
        i=total-1;
    ponFoto(i);
}
//si la imagen izquierda o derecha no tiene filtro le activa filtro escvala de grises, de lo contrario se lo quita
function cambiaColor(){
    if(this.style.filter==="none")
        this.style.filter="grayscale(100%)";
    else this.style.filter="none"
}
//si el contenedor tiene un ancho de 50% le asigna ancho de 40%, de lo contrario le asigna ancho de 50%
function cambiaWidth(){
    if (this.style.width==="50%")
        this.style.width="40%";
    else this.style.width="50%";
}
//Programa principal: Llama a la función iniciaTodo, avanza una vez, y cada 4 segundos llama a la funcion avanza
function programa(){
    iniciaTodo();
    avanza();
    setInterval(avanza,4000);
}
//recibe el indice de la foto que se va a cargar en el parámetro fo
function ponFoto(fo){
    imagen.src=nombFoto[fo]; //asigna al src de la imagen principal el nombre correspondiente del array de los nombres de las fotos
    //asigna al src de la imagen miniatura izquierda el nombre de la imagen anterior a la principal controlando que no se salga del array
    imagI.src=nombFoto[fo-1<0?total-1:fo-1]; 
    //Igual con la anterior para la miniatura derecha
    imagD.src=nombFoto[fo+1===total?0:fo+1];
    //activa el radiobutton del array con el mismo indice que el array de nombres de imagen
    rad[fo].checked=true;
    //cambia el texto del elemento título con el nombre del array de descripciones con el mismo índice
    titulo.innerHTML=descripcion[fo].textContent;
}