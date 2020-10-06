
var request, formulario_formu;

formulario_formu = document.forms["formu"];
formulario_formu.addEventListener("submit", cargarInfo, false); //Cada vez que se le de a submit, se va a prevenir que se mande



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
            "&password=" + encodeURI(password) +
            "&confirmacion=" + encodeURI(confirmacion);
}
function ProcesaRespuesta() {
    if (request.readyState === 4 & request.status === 200) {
        console.log(request.response);
        alert("Se ha registrado con exito");
        formulario_formu.reset();


    }
}

function validarUsername() {
    let username = formulario_formu.elements["username"].value;
    var usuarioFinal = username + " no disponible, use otro.";
    var respuesta = "";


    var ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function () {//callback
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById('available').innerText = this.responseText;
            respuesta = this.responseText;
            var comparacion = usuarioFinal.localeCompare(respuesta);
            console.log(comparacion);
            console.log(usuarioFinal);
            console.log(respuesta);

            if (comparacion == -1) {
                document.getElementById('botonSub').disabled = true;
                alert("Este usuario no esta disponible, no podra registrarse con este usuario.");
            } else {
                document.getElementById('botonSub').disabled = false;

            }
        }
    }

    ajax.open("POST", "ServicioComprobar", true);
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.send("username=" + username);
}

function Magic() {
    var ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function () {//callback
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById('available').innerText = this.responseText;
            respuesta = this.responseText;
            var comparacion = usuarioFinal.localeCompare(respuesta);
            console.log(comparacion);
            console.log(usuarioFinal);
            console.log(respuesta);

            if (comparacion == -1) {
                document.getElementById('botonSub').disabled = true;
                alert("Este usuario no esta disponible, no podra registrarse con este usuario.");
            } else {
                document.getElementById('botonSub').disabled = false;

            }
        }
    }

    ajax.open("POST", "servicioMagic", true);
    ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajax.send("answer=" + answer);
}
