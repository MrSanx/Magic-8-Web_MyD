
var request, formulario_formu;

formulario_formu = document.forms["formu"];

formulario_formu.addEventListener("submit", cargarInfo, false); //Cada vez que se le de a submit, se va a prevenir que se mande

function comparar() {
     let username = formulario_formu.elements["username"].value;
    let password = formulario_formu.elements["password"].value;
    let confirmacion = formulario_formu.elements["confirm"].value;
    
    if (!password.equalsignorecase(confirmacion)) {
        alert("joven, las contraseñas no son iguales");
    }
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
 


    return "username=" + encodeURI(username) +
            "&password=" + encodeURI(password);
}
function ProcesaRespuesta() {
    if (request.readyState === 4 & request.status === 200) {
        console.log(request.response);
       
    }
}
