
var request, formulario_formu;

formulario_formu = document.forms["formu"];

formulario_formu.addEventListener("submit", cargarInfo, false); //Cada vez que se le de a submit, se va a prevenir que se mande


function validarUsername() {
    let username = formulario_formu.elements["username"].value;
    
    var ajax = new XMLHttpRequest();
 
    ajax.onreadystatechange = function () {//callback
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById('available').innerText = this.responseText;
        }
    }

    ajax.open("POST", "ServicioComprobar", true);
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.send("username=" + username);
}

function cargarInfo(e) {
    e.preventDefault();
    inicializarXHMHttpRequest();
    request.onreadystatechange = ProcesaRespuesta;
    request.open("POST", "servicioLogin", true);
    //1. Tipo de peticion, si es post o get
    //2.  Url
    //3. La peticion sera asincrona 
    request.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    //Especifica la cadena de peticion
    request.send(crear_query_String());

}
function inicializarXHMHttpRequest() {
    request = new XMLHttpRequest(); //Inicializa la variable request con el operador new
}



function crear_query_String() {
    let username = formulario_formu.elements["username"].value;
    let password = formulario_formu.elements["password"].value;
 let confirmacion = formulario_formu.elements["confirm"].value;


    return "username=" + encodeURI(username) +
            "&password=" + encodeURI(password)+
            "&confirmacion=" + encodeURI(confirmacion);
}
function ProcesaRespuesta() {
    if (request.readyState === 4 & request.status === 200) {
        console.log(request.response);
       
    }
}
